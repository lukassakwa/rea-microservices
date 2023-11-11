package com.rea.system.offer.application.engine.service.save;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.application.engine.ports.output.EngineAvailableOfferDataService;
import com.rea.system.offer.application.engine.ports.output.EngineHistoricalOfferDataService;
import com.rea.system.offer.application.engine.service.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rea.system.common.model.EstateServiceType;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
class DataServiceImpl implements DataService {

    private final EngineAvailableOfferDataService availableOfferDataService;
    private final EngineHistoricalOfferDataService historicalOfferDataService;

    @Override
    @Transactional
    public Mono<ResolveOffer> upsertOfferAndMoveToHistoricalIfNecessarily(ResolveOffer resolveOffer) {
        EstateServiceType estateServiceType = resolveOffer.getEstateServiceType();
        Mono<ResolveOffer> duplicateOfferDto = availableOfferDataService.findByDuplicateKey(resolveOffer.getDuplicateKey(), estateServiceType);
        return duplicateOfferDto
                .flatMap(duplicate -> {
                    if (duplicate != null) {
                        duplicate.processDuplicateData();
                        if (!resolveOffer.getPrice().equals(duplicate.getPrice())) {
                            return historicalOfferDataService.save(duplicate, estateServiceType);
                        }
                        return Mono.just(duplicate);
                    }
                    return Mono.empty();
                })
                .flatMap(savedDuplicate -> {
                    resolveOffer.updateModifiedDate();
                    return availableOfferDataService.update(savedDuplicate.getPublicId(), resolveOffer, estateServiceType);
                })
                .switchIfEmpty(Mono.defer(() -> {
                    resolveOffer.updateCreatedDate();
                    return availableOfferDataService.save(resolveOffer, estateServiceType);
                }));
    }
}
