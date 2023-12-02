package com.rea.system.offer.infrastructure.dataaccess.service;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.HistoricalRentOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.RentOffer;
import com.rea.system.offer.infrastructure.dataaccess.repository.HistoricalRentRepository;
import com.rea.system.offer.infrastructure.dataaccess.repository.RentOfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RentOfferService implements AvailableEngineOfferService, HistoricalEngineOfferService {

    private final RentOfferRepository rentOfferRepository;
    private final OfferMapper offerMapper;
    private final HistoricalRentRepository historicalRentRepository;


    @Override
    public Mono<ResolveOffer> save(ResolveOffer resolveOffer) {
        Mono<RentOffer> savedOffer = rentOfferRepository.save(offerMapper.toRentEntity(resolveOffer));
        return savedOffer.map(offerMapper::toResolveRentDto);
    }

    @Override
    public Mono<ResolveOffer> update(String offerId, ResolveOffer updatedOffer) {
        return findResolveOfferById(offerId)
                .map(foundOffer -> offerMapper.updateOffer(foundOffer, updatedOffer))
                .flatMap(this::save);
    }

    @Override
    public Mono<ResolveOffer> findByDuplicateKey(String dupicateKey) {
        return rentOfferRepository.findByDuplicateKey(dupicateKey)
                .map(offerMapper::toResolveRentDto);
    }

    @Override
    public Mono<ResolveOffer> saveHistorical(ResolveOffer offer) {
        Mono<HistoricalRentOffer> historicalRentOffer = historicalRentRepository.save(offerMapper.toHistoricalRentEntity(offer));
        return historicalRentOffer.map(offerMapper::toResolveRentDto);
    }

    private Mono<ResolveOffer> findResolveOfferById(String offerId) {
        Mono<RentOffer> offer = rentOfferRepository.findById(offerId)
                .switchIfEmpty(Mono.error(new IllegalStateException("Offer does not exist")));
        return offer.map(offerMapper::toResolveRentDto);
    }

}
