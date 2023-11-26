package com.rea.system.offer.application.domain.ports.output;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.rea.system.offer.application.domain.core.DomainOffer;
import org.springframework.data.domain.Sort;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DomainAvailableOfferDataService {

    Flux<DomainOffer> findFilteredAndSortedOffers(BooleanExpression expression, Sort sort, EstateServiceType estateServiceType);

    Mono<DomainOffer> findById(String offerId, EstateServiceType estateServiceType);

}