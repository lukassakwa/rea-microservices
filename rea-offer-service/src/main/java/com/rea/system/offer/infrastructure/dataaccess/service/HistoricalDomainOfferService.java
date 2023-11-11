package com.rea.system.offer.infrastructure.dataaccess.service;

import com.rea.system.offer.application.domain.entity.DomainOffer;
import reactor.core.publisher.Flux;

import java.util.List;

public interface HistoricalDomainOfferService {

    Flux<DomainOffer> findByPublicId(String publicId);

}
