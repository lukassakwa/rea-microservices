package com.rea.system.offer.application.domain.ports.input;

import rea.system.common.dto.OfferDto;
import org.springframework.data.domain.Page;
import rea.system.common.model.EstateServiceType;
import reactor.core.publisher.Flux;

import java.util.List;
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
