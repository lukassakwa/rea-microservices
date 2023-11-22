package com.rea.system.offer.application.domain.ports.input;

import com.rea.system.offer.application.domain.core.DomainOffer;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

import java.util.Set;

public interface OfferService {

    Flux<DomainOffer> findOffers(EstateServiceType estateServiceType,
                                 Integer priceFrom,
                                 Integer priceTo,
                                 Double metersFrom,
                                 Double metersTo);

    Flux<DomainOffer> findOffers(EstateServiceType estateServiceType, Set<String> offerIds);

    Flux<DomainOffer> getMonitoringData(String publicId, EstateServiceType serviceType);

}
