package com.rea.system.offer.application.engine.service.save;

import com.rea.system.offer.application.engine.ports.output.EngineAvailableOfferDataService;
import com.rea.system.offer.application.engine.ports.output.EngineHistoricalOfferDataService;
import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.application.engine.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rea.system.common.model.EstateServiceType;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class DataServiceImpl implements DataService {

    private final EngineAvailableOfferDataService availableOfferDataService;
    private final EngineHistoricalOfferDataService historicalOfferDataService;

    @Override
    @Transactional
    public ResolveOffer upsertOfferAndMoveToHistoricalIfNecessarily(ResolveOffer resolveOffer) {
        EstateServiceType estateServiceType = resolveOffer.getEstateServiceType();
        Optional<ResolveOffer> duplicateOfferDto = availableOfferDataService.findByDuplicateKey(resolveOffer.getDuplicateKey(), estateServiceType);
        if (duplicateOfferDto.isPresent()) {
            ResolveOffer duplicatedResolveOffer = duplicateOfferDto.get();
            if (!resolveOffer.getPrice().equals(duplicatedResolveOffer.getPrice())) {
                duplicatedResolveOffer.processHistoricalData();
                historicalOfferDataService.save(duplicatedResolveOffer, estateServiceType);
            }
            resolveOffer.updateModifiedDate();
            return availableOfferDataService.update(duplicatedResolveOffer.getId(), resolveOffer, estateServiceType);
        }
        resolveOffer.updateCreatedDate();
        return availableOfferDataService.save(resolveOffer, estateServiceType);
    }
}
