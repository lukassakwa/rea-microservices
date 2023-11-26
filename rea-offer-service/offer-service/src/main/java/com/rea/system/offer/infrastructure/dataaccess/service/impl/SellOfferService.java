package com.rea.system.offer.infrastructure.dataaccess.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.rea.system.offer.application.domain.core.DomainOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.SellOffer;
import com.rea.system.offer.infrastructure.dataaccess.mapper.HistoricalOfferMapper;
import com.rea.system.offer.infrastructure.dataaccess.mapper.OfferMapper;
import com.rea.system.offer.infrastructure.dataaccess.repository.HistoricalSellRepository;
import com.rea.system.offer.infrastructure.dataaccess.repository.SellOfferRepository;
import com.rea.system.offer.infrastructure.dataaccess.service.AvailableDomainOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.HistoricalDomainOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SellOfferService implements AvailableDomainOfferService, HistoricalDomainOfferService {

    private final SellOfferRepository sellOfferRepository;
    private final OfferMapper offerMapper;
    private final HistoricalSellRepository historicalSellRepository;
    private final HistoricalOfferMapper historicalOfferMapper;

    @Override
    public Flux<DomainOffer> findFilteredAndSortedOffers(BooleanExpression expression, Sort sort) {
        return sellOfferRepository.findAll(expression, sort)
                .map(offerMapper::toDomainSellDto)
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<DomainOffer> findById(String offerId) {
        Mono<SellOffer> offer = sellOfferRepository.findById(offerId)
                .switchIfEmpty(Mono.error(new IllegalStateException("Offer does not exist")));
        return offer.map(offerMapper::toDomainSellDto);
    }

    @Override
    public Flux<DomainOffer> findByPublicId(String publicId) {
        return historicalSellRepository.findAllByPublicId(publicId)
                .map(historicalOfferMapper::toDomainSellDto);
    }

}
