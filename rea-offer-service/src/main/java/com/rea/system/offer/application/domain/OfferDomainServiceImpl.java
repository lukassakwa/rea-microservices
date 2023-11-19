package com.rea.system.offer.application.domain;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.rea.system.offer.application.domain.entity.DomainOffer;
import com.rea.system.offer.application.domain.entity.Fillter;
import com.rea.system.offer.application.domain.ports.input.OfferService;
import com.rea.system.offer.application.domain.ports.output.DomainAvailableOfferDataService;
import com.rea.system.offer.application.domain.ports.output.DomainHistoricalOfferDataService;
import com.rea.system.offer.infrastructure.web.resource.OfferResponseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.dto.offer.OfferDto;
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
    private final OfferResponseMapper offerResponseMapper;

    @Override
    public Flux<DomainOffer> findOffers(EstateServiceType estateServiceType,
                                     Set<String> offerIds,
                                     Integer pageIndex,
                                     Integer pageSize,
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
                .offerIds(offerIds)
                .build();
        BooleanExpression expression = DomainQueryBuilderImpl.builder()
                .fillter(filter)
                .build()
                .buildQuery();
        return availableOfferDataService.findOffersById(expression, pageIndex, pageSize, estateServiceType);
    }

    @Override
    public Flux<DomainOffer> getMonitoringData(String publicId, EstateServiceType serviceType) {
        Flux<DomainOffer> monitorOffers = historicalOfferService.findByPublicId(publicId, serviceType);
        Mono<DomainOffer> offerDto = availableOfferDataService.findById(publicId, serviceType);
        return Flux.concat(monitorOffers, offerDto)
                .sort(Comparator.comparing(DomainOffer::getModifiedAt).reversed());
    }

}
