package com.rea.system.offer.infrastructure.dataaccess;

import com.rea.system.offer.application.domain.entity.DomainOffer;
import com.rea.system.offer.application.domain.entity.Fillter;
import com.rea.system.offer.application.domain.ports.output.DomainAvailableOfferDataService;
import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.application.engine.ports.output.EngineAvailableOfferDataService;
import com.rea.system.offer.infrastructure.dataaccess.service.AvailableDomainOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.AvailableEngineOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.model.EstateServiceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OfferEngineDataServiceProviderImpl implements EngineAvailableOfferDataService, DomainAvailableOfferDataService {

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
    public Flux<DomainOffer> findOffersById(Fillter fillter, int pageIndex, int pageSize) {
        AvailableDomainOfferService offerService = resolver.resolveDomainOfferService(fillter.getService());
        return offerService.findOffersById(fillter, pageIndex, pageSize);
    }

    @Override
    public Mono<DomainOffer> findById(String offerId, EstateServiceType estateServiceType) {
        AvailableDomainOfferService offerService = resolver.resolveDomainOfferService(estateServiceType);
        return offerService.findById(offerId);
    }
}