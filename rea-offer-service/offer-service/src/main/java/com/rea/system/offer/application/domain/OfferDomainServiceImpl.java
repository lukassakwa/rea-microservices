package com.rea.system.offer.application.domain;

import com.rea.system.offer.application.domain.core.DomainOffer;
import com.rea.system.offer.application.domain.core.Fillter;
import com.rea.system.offer.application.domain.ports.input.OfferService;
import com.rea.system.offer.application.domain.ports.output.DomainAvailableOfferDataService;
import com.rea.system.offer.application.domain.ports.output.DomainHistoricalOfferDataService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.Set;

@Service
@AllArgsConstructor
public class OfferDomainServiceImpl implements OfferService {

    private final DomainHistoricalOfferDataService historicalOfferService;
    private final DomainAvailableOfferDataService availableOfferDataService;

    @Override
    public Flux<DomainOffer> findOffers(EstateServiceType estateServiceType,
                                     Integer priceFrom,
                                     Integer priceTo,
                                     Double metersFrom,
                                     Double metersTo) {
        Fillter filter = Fillter.builder()
                .service(estateServiceType)
                .priceFrom(priceFrom)
                .priceTo(priceTo)
                .metersFrom(metersFrom)
                .metersTo(metersTo)
                .build();
        DomainQueryBuilder queryBuilder = DomainQueryBuilder.builder()
                .fillter(filter)
                .build();
        queryBuilder.buildQuery();
        return availableOfferDataService.findOffersOrReturnAll(
                queryBuilder.getExpression(),
                queryBuilder.getSort(),
                estateServiceType);
    }

    @Override
    public Flux<DomainOffer> findOffers(EstateServiceType estateServiceType, Set<String> offerIds) {
        Fillter filter = Fillter.builder()
                .service(estateServiceType)
                .offerIds(offerIds)
                .build();
        DomainQueryBuilder queryBuilder = DomainQueryBuilder.builder()
                .fillter(filter)
                .build();
        queryBuilder.buildQuery();
        return availableOfferDataService.findOffersOrReturnEmpty(
                queryBuilder.getExpression(),
                queryBuilder.getSort(),
                estateServiceType);
    }

    @Override
    public Flux<DomainOffer> getMonitoringData(String publicId, EstateServiceType serviceType) {
        Flux<DomainOffer> monitorOffers = historicalOfferService.findByPublicId(publicId, serviceType);
        Mono<DomainOffer> offerDto = availableOfferDataService.findById(publicId, serviceType);
        return Flux.concat(monitorOffers, offerDto)
                .sort(Comparator.comparing(DomainOffer::getModifiedAt).reversed());
    }

}
