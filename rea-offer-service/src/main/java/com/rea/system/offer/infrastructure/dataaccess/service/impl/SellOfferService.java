package com.rea.system.offer.infrastructure.dataaccess.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.rea.system.offer.application.domain.entity.DomainOffer;
import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.SellOffer;
import com.rea.system.offer.infrastructure.dataaccess.mapper.OfferMapper;
import com.rea.system.offer.infrastructure.dataaccess.repository.SellOfferRepository;
import com.rea.system.offer.infrastructure.dataaccess.service.AvailableDomainOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.AvailableEngineOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static com.rea.system.offer.infrastructure.dataaccess.entity.Offer.ID;
import static com.rea.system.offer.infrastructure.dataaccess.entity.Offer.MODIFIED_DATE;

@Service
@RequiredArgsConstructor
public class SellOfferService implements AvailableEngineOfferService, AvailableDomainOfferService {

    private final SellOfferRepository sellOfferRepository;
    private final OfferMapper offerMapper;

    @Override
    public Mono<ResolveOffer> findByDuplicateKey(String dupicateKey) {
        return sellOfferRepository.findByDuplicateKey(dupicateKey)
                .map(offerMapper::toResolveSellDto);
    }

    @Override
    public Mono<ResolveOffer> save(ResolveOffer offerDto) {
        Mono<SellOffer> offer = sellOfferRepository.save(offerMapper.toSellEntity(offerDto));
        return offer.map(offerMapper::toResolveSellDto);
    }

    @Override
    public Mono<ResolveOffer> update(String offerId, ResolveOffer updatedOffer) {
        return findResolveOfferById(offerId)
                .map(foundOffer -> offerMapper.updateOffer(foundOffer, updatedOffer))
                .flatMap(this::save);
    }

    @Override
    public Flux<DomainOffer> findOffersById(BooleanExpression expression, int pageIndex, int pageSize) {
        Sort sort = Sort.by(Sort.Order.desc(MODIFIED_DATE), Sort.Order.asc(ID));
        Pageable pageable = PageRequest.of(pageIndex, pageSize, sort);
        return Optional.ofNullable(expression)
                .map(expr -> sellOfferRepository.findAllBy(expr, pageable))
                .orElse(sellOfferRepository.findAllBy(pageable))
                .map(offerMapper::toDomainSellDto);
    }

    @Override
    public Mono<DomainOffer> findById(String offerId) {
        Mono<SellOffer> offer = sellOfferRepository.findById(offerId)
                .switchIfEmpty(Mono.error(new IllegalStateException("Offer does not exist")));
        return offer.map(offerMapper::toDomainSellDto);
    }

    private Mono<ResolveOffer> findResolveOfferById(String offerId) {
        Mono<SellOffer> offer = sellOfferRepository.findById(offerId)
                .switchIfEmpty(Mono.error(new IllegalStateException("Offer does not exist")));
        return offer.map(offerMapper::toResolveSellDto);
    }

}
