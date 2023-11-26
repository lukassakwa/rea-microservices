package com.rea.system.offer.infrastructure.dataaccess;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.rea.system.offer.application.domain.core.DomainOffer;
import com.rea.system.offer.application.domain.ports.output.DomainAvailableOfferDataService;
import com.rea.system.offer.application.domain.ports.output.DomainHistoricalOfferDataService;
import com.rea.system.offer.infrastructure.dataaccess.service.AvailableDomainOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.HistoricalDomainOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OfferEngineDataServiceProviderImpl implements DomainAvailableOfferDataService, DomainHistoricalOfferDataService {

    private final OfferServiceResolver resolver;

    @Override
    public Flux<DomainOffer> findFilteredAndSortedOffers(BooleanExpression expression, Sort sort, EstateServiceType estateServiceType) {
        AvailableDomainOfferService offerService = resolver.resolveDomainOfferService(estateServiceType);
        return offerService.findFilteredAndSortedOffers(expression, sort);
    }

    @Override
    public Mono<DomainOffer> findById(String offerId, EstateServiceType estateServiceType) {
        AvailableDomainOfferService offerService = resolver.resolveDomainOfferService(estateServiceType);
        return offerService.findById(offerId);
    }

    @Override
    public Flux<DomainOffer> findByPublicId(String publicId, EstateServiceType estateServiceType) {
        HistoricalDomainOfferService historicalOfferService = resolver.resolveHistoricalDomainOfferService(estateServiceType);
        return historicalOfferService.findByPublicId(publicId);
    }

}