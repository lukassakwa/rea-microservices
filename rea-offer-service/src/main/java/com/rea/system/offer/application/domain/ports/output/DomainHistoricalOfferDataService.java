package com.rea.system.offer.application.domain.ports.output;

import com.rea.system.offer.application.domain.entity.DomainOffer;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

public interface DomainHistoricalOfferDataService {

    Flux<DomainOffer> findByPublicId(String publicId, EstateServiceType estateServiceType);

}
