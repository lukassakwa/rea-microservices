package com.rea.system.offer.infrastructure.dataaccess;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.rea.system.offer.application.domain.core.DomainOffer;
import com.rea.system.offer.application.domain.ports.output.DomainAvailableOfferDataService;
import com.rea.system.offer.infrastructure.dataaccess.service.AvailableDomainOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OfferEngineDataServiceProviderImpl implements DomainAvailableOfferDataService {

    private final OfferServiceResolver resolver;

    @Override
    public Flux<DomainOffer> findOffersOrReturnAll(BooleanExpression expression, Sort sort, EstateServiceType estateServiceType) {
        AvailableDomainOfferService offerService = resolver.resolveDomainOfferService(estateServiceType);
        return offerService.findOffersOrReturnAll(expression, sort);
    }

    @Override
    public Mono<DomainOffer> findById(String offerId, EstateServiceType estateServiceType) {
        AvailableDomainOfferService offerService = resolver.resolveDomainOfferService(estateServiceType);
        return offerService.findById(offerId);
    }

    @Override
    public Flux<DomainOffer> findOffersOrReturnEmpty(BooleanExpression expression, Sort sort, EstateServiceType estateServiceType) {
        AvailableDomainOfferService offerService = resolver.resolveDomainOfferService(estateServiceType);
        return offerService.findOffersOrReturnEmpty(expression, sort);
    }
}