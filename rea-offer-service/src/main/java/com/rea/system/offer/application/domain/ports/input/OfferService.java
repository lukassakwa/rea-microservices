package com.rea.system.offer.application.domain.ports.input;

import rea.system.common.dto.offer.OfferDto;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

import java.util.Set;

public interface OfferService {

    Flux<OfferDto> findOffers(EstateServiceType estateServiceType,
                              Set<String> offerIds,
                              Integer pageIndex,
                              Integer pageSize,
                              Integer priceFrom,
                              Integer priceTo,
                              Double metersFrom,
                              Double metersTo);

    Flux<OfferDto> getMonitoringData(String publicId, EstateServiceType serviceType);

}
