package com.rea.system.offer.application.domain;

import com.rea.system.offer.application.domain.entity.DomainOffer;
import com.rea.system.offer.application.domain.entity.Fillter;
import com.rea.system.offer.application.domain.ports.input.OfferService;
import com.rea.system.offer.application.domain.ports.output.DomainAvailableOfferDataService;
import com.rea.system.offer.application.domain.ports.output.DomainHistoricalOfferDataService;
import com.rea.system.offer.application.domain.presenter.OfferResponseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.dto.OfferDto;
import rea.system.common.model.EstateServiceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OfferDomainServiceImpl implements OfferService {

    private final DomainHistoricalOfferDataService historicalOfferService;
    private final DomainAvailableOfferDataService availableOfferDataService;
    private final OfferResponseMapper offerResponseMapper;

    @Override
    public Flux<OfferDto> findOffers(EstateServiceType estateServiceType,
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
        return availableOfferDataService.findOffersById(filter, pageIndex, pageSize)
                .map(offerResponseMapper::toResponse);
    }

    @Override
    public Flux<OfferDto> getMonitoringData(String publicId, EstateServiceType serviceType) {
        Flux<DomainOffer> monitorOffers = historicalOfferService.findByPublicId(publicId, serviceType);
        Mono<DomainOffer> offerDto = availableOfferDataService.findById(publicId, serviceType);
        return Flux.concat(monitorOffers, offerDto)
                .sort(Comparator.comparing(DomainOffer::getModifiedAt).reversed())
                .map(offerResponseMapper::toResponse);
    }

}
