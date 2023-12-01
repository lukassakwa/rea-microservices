package com.rea.system.offer.infrastructure.dataaccess.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.rea.system.offer.application.domain.core.DomainOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.RentOffer;
import com.rea.system.offer.infrastructure.dataaccess.mapper.HistoricalOfferMapper;
import com.rea.system.offer.infrastructure.dataaccess.mapper.OfferMapper;
import com.rea.system.offer.infrastructure.dataaccess.repository.HistoricalRentRepository;
import com.rea.system.offer.infrastructure.dataaccess.repository.RentOfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RentOfferService implements AvailableDomainOfferService, HistoricalDomainOfferService {

    private final RentOfferRepository rentOfferRepository;
    private final OfferMapper offerMapper;
    private final HistoricalRentRepository historicalRentRepository;
    private final HistoricalOfferMapper historicalOfferMapper;

    @Override
    public Flux<DomainOffer> findFilteredAndSortedOffers(BooleanExpression expression, Sort sort) {
        return rentOfferRepository.findAll(expression, sort)
                .map(offerMapper::toDomainRentDto)
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<DomainOffer> findById(String offerId) {
        Mono<RentOffer> offer = rentOfferRepository.findById(offerId)
                .switchIfEmpty(Mono.error(new IllegalStateException("Offer does not exist")));
        return offer.map(offerMapper::toDomainRentDto);
    }

    @Override
    public Flux<DomainOffer> findByPublicId(String publicId) {
        return historicalRentRepository.findAllByPublicId(publicId)
                .map(historicalOfferMapper::toDomainRentDto);
    }

}
