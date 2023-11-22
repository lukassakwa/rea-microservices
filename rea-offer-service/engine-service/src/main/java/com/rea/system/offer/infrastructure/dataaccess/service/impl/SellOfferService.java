package com.rea.system.offer.infrastructure.dataaccess.service.impl;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.SellOffer;
import com.rea.system.offer.infrastructure.dataaccess.mapper.OfferMapper;
import com.rea.system.offer.infrastructure.dataaccess.repository.SellOfferRepository;
import com.rea.system.offer.infrastructure.dataaccess.service.AvailableEngineOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SellOfferService implements AvailableEngineOfferService {

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

    private Mono<ResolveOffer> findResolveOfferById(String offerId) {
        Mono<SellOffer> offer = sellOfferRepository.findById(offerId)
                .switchIfEmpty(Mono.error(new IllegalStateException("Offer does not exist")));
        return offer.map(offerMapper::toResolveSellDto);
    }

}
