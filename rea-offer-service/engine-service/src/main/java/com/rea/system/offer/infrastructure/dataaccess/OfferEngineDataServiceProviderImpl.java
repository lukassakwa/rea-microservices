package com.rea.system.offer.infrastructure.dataaccess;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.application.engine.ports.output.EngineOfferDataService;
import com.rea.system.offer.infrastructure.dataaccess.service.AvailableEngineOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.HistoricalEngineOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OfferEngineDataServiceProviderImpl implements EngineOfferDataService {

    private final OfferServiceResolver resolver;

    @Override
    public Mono<ResolveOffer> findByDuplicateKey(String duplicateKey, EstateServiceType estateServiceType) {
        AvailableEngineOfferService offerService = resolver.resolveEngineOfferService(estateServiceType);
        return offerService.findByDuplicateKey(duplicateKey);
    }

    @Override
    public Mono<ResolveOffer> save(ResolveOffer offerDto, EstateServiceType estateServiceType) {
        AvailableEngineOfferService offerService = resolver.resolveEngineOfferService(estateServiceType);
        return offerService.save(offerDto);
    }

    @Override
    public Mono<ResolveOffer> update(String offerId, ResolveOffer updatedOffer, EstateServiceType estateServiceType) {
        AvailableEngineOfferService offerService = resolver.resolveEngineOfferService(estateServiceType);
        return offerService.update(offerId, updatedOffer);
    }

    @Override
    public Mono<ResolveOffer> saveHistorical(ResolveOffer resolveOffer, EstateServiceType estateServiceType) {
        HistoricalEngineOfferService historicalOfferService = resolver.resolveHistoricalEngineOfferService(estateServiceType);
        return historicalOfferService.save(resolveOffer);
    }

}