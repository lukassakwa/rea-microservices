package com.rea.system.offer.infrastructure.dataaccess.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.rea.system.offer.application.domain.core.DomainOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.Offer;
import com.rea.system.offer.infrastructure.dataaccess.entity.SellOffer;
import com.rea.system.offer.infrastructure.dataaccess.mapper.OfferMapper;
import com.rea.system.offer.infrastructure.dataaccess.repository.SellOfferRepository;
import com.rea.system.offer.infrastructure.dataaccess.service.AvailableDomainOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellOfferService implements AvailableDomainOfferService {

    private final SellOfferRepository sellOfferRepository;
    private final OfferMapper offerMapper;

    @Override
    public Flux<DomainOffer> findOffersOrReturnAll(BooleanExpression expression, Sort sort) {
        return Optional.ofNullable(expression)
                .map(expr -> sellOfferRepository.findAll(expr, sort))
                .orElse(sellOfferRepository.findAll(sort))
                .map(offerMapper::toDomainSellDto);
    }

    @Override
    public Mono<DomainOffer> findById(String offerId) {
        Mono<SellOffer> offer = sellOfferRepository.findById(offerId)
                .switchIfEmpty(Mono.error(new IllegalStateException("Offer does not exist")));
        return offer.map(offerMapper::toDomainSellDto);
    }

    @Override
    public Flux<DomainOffer> findOffersOrReturnEmpty(BooleanExpression expression, Sort sort) {
        return sellOfferRepository.findAll(expression, sort)
                .map(offerMapper::toDomainSellDto)
                .switchIfEmpty(Flux.empty());
    }

}
