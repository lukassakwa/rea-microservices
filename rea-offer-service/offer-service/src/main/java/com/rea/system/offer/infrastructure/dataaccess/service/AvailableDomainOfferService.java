package com.rea.system.offer.infrastructure.dataaccess.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.rea.system.offer.application.domain.core.DomainOffer;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AvailableDomainOfferService {

    Flux<DomainOffer> findFilteredAndSortedOffers(BooleanExpression expression, Sort sort);

    Mono<DomainOffer> findById(String offerId);

}
