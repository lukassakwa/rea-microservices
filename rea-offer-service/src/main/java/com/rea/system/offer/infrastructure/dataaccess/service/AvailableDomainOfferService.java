package com.rea.system.offer.infrastructure.dataaccess.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.rea.system.offer.application.domain.entity.DomainOffer;
import com.rea.system.offer.application.domain.entity.Fillter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AvailableDomainOfferService {

    Flux<DomainOffer> findOffersById(BooleanExpression expression, int pageIndex, int pageSize);

    Mono<DomainOffer> findById(String offerId);

}
