package com.rea.system.offer.application.engine.service.save;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.application.engine.ports.output.EngineAvailableOfferDataService;
import com.rea.system.offer.application.engine.ports.output.EngineHistoricalOfferDataService;
import com.rea.system.offer.application.engine.service.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rea.system.common.model.offer.EstateServiceType;
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
                .map(ResolveOffer::processDuplicateData)
                .flatMap(duplicate -> updateHistoricalIfNecessery(duplicate, resolveOffer))
                .flatMap(duplicate -> updateOffer(duplicate, resolveOffer))
                .switchIfEmpty(Mono.defer(() -> this.createOffer(resolveOffer)));
    }

    private Mono<ResolveOffer> updateHistoricalIfNecessery(ResolveOffer duplicate, ResolveOffer resolveOffer) {
        if (!resolveOffer.getPrice().equals(duplicate.getPrice())) {
            return historicalOfferDataService.save(duplicate, resolveOffer.getEstateServiceType());
        }
        return Mono.just(duplicate);
    }

    private Mono<ResolveOffer> updateOffer(ResolveOffer duplicate, ResolveOffer resolveOffer) {
        resolveOffer.updateModifiedDate();
        return availableOfferDataService.update(duplicate.getPublicId(), resolveOffer, resolveOffer.getEstateServiceType());
    }
    private Mono<ResolveOffer> createOffer(ResolveOffer resolveOffer) {
        resolveOffer.updateCreatedDate();
        return availableOfferDataService.save(resolveOffer, resolveOffer.getEstateServiceType());
    }
}
