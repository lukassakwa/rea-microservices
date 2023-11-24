package com.rea.system.offer.infrastructure.dataaccess.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.rea.system.offer.application.domain.core.DomainOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.Offer;
import com.rea.system.offer.infrastructure.dataaccess.entity.RentOffer;
import com.rea.system.offer.infrastructure.dataaccess.mapper.OfferMapper;
import com.rea.system.offer.infrastructure.dataaccess.repository.RentOfferRepository;
import com.rea.system.offer.infrastructure.dataaccess.service.AvailableDomainOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentOfferService implements AvailableDomainOfferService {

    private final RentOfferRepository rentOfferRepository;
    private final OfferMapper offerMapper;

    @Override
    public Flux<DomainOffer> findOffersOrReturnAll(BooleanExpression expression, Sort sort) {
        return Optional.ofNullable(expression)
                .map(expr -> rentOfferRepository.findAll(expr, sort))
                .orElse(rentOfferRepository.findAll(sort))
                .map(offerMapper::toDomainRentDto);
    }

    @Override
    public Mono<DomainOffer> findById(String offerId) {
        Mono<RentOffer> offer = rentOfferRepository.findById(offerId)
                .switchIfEmpty(Mono.error(new IllegalStateException("Offer does not exist")));
        return offer.map(offerMapper::toDomainRentDto);
    }

    @Override
    public Flux<DomainOffer> findOffersOrReturnEmpty(BooleanExpression expression, Sort sort) {
        return rentOfferRepository.findAll(expression, sort)
                .map(offerMapper::toDomainRentDto)
                .switchIfEmpty(Flux.empty());
    }

}
