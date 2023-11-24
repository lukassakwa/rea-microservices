package com.rea.system.offer.infrastructure.dataaccess.service;

import com.rea.system.offer.application.domain.core.DomainOffer;
import reactor.core.publisher.Flux;

public interface HistoricalDomainOfferService {

    Flux<DomainOffer> findByPublicId(String publicId);

}
