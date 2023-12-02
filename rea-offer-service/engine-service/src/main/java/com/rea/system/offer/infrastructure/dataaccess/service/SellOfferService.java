package com.rea.system.offer.infrastructure.dataaccess.service;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.HistoricalSellOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.SellOffer;
import com.rea.system.offer.infrastructure.dataaccess.repository.HistoricalSellRepository;
import com.rea.system.offer.infrastructure.dataaccess.repository.SellOfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SellOfferService implements AvailableEngineOfferService, HistoricalEngineOfferService {

    private final SellOfferRepository sellOfferRepository;
    private final HistoricalSellRepository historicalSellRepository;
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
    public Mono<ResolveOffer> saveHistorical(ResolveOffer offer) {
        Mono<HistoricalSellOffer> historicalSellOffer = historicalSellRepository.save(offerMapper.toHistoricalSellEntity(offer));
        return historicalSellOffer.map(offerMapper::toResolveSellDto);
    }

    private Mono<ResolveOffer> findResolveOfferById(String offerId) {
        Mono<SellOffer> offer = sellOfferRepository.findById(offerId)
                .switchIfEmpty(Mono.error(new IllegalStateException("Offer does not exist")));
        return offer.map(offerMapper::toResolveSellDto);
    }

}
