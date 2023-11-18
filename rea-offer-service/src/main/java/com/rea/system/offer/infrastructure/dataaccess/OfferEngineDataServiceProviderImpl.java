package com.rea.system.offer.infrastructure.dataaccess;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.rea.system.offer.application.domain.entity.DomainOffer;
import com.rea.system.offer.application.domain.entity.Fillter;
import com.rea.system.offer.application.domain.ports.output.DomainAvailableOfferDataService;
import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.application.engine.ports.output.EngineAvailableOfferDataService;
import com.rea.system.offer.infrastructure.dataaccess.service.AvailableDomainOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.AvailableEngineOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.model.offer.EstateServiceType;
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
    public Flux<DomainOffer> findOffersById(BooleanExpression expression, int pageIndex, int pageSize, EstateServiceType estateServiceType) {
        AvailableDomainOfferService offerService = resolver.resolveDomainOfferService(estateServiceType);
        return offerService.findOffersById(expression, pageIndex, pageSize);
    }

    @Override
    public Mono<DomainOffer> findById(String offerId, EstateServiceType estateServiceType) {
        AvailableDomainOfferService offerService = resolver.resolveDomainOfferService(estateServiceType);
        return offerService.findById(offerId);
    }
}