package com.rea.system.offer.infrastructure.dataaccess.service.impl;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.HistoricalRentOffer;
import com.rea.system.offer.infrastructure.dataaccess.mapper.HistoricalOfferMapper;
import com.rea.system.offer.infrastructure.dataaccess.repository.HistoricalRentRepository;
import com.rea.system.offer.infrastructure.dataaccess.service.HistoricalEngineOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class HistoricalRentService implements HistoricalEngineOfferService {

    private final HistoricalRentRepository historicalRentRepository;
    private final HistoricalOfferMapper historicalOfferMapper;

    @Override
    public Mono<ResolveOffer> save(ResolveOffer offer) {
        Mono<HistoricalRentOffer> historicalRentOffer = historicalRentRepository.save(historicalOfferMapper.toRentEntity(offer));
        return historicalRentOffer.map(historicalOfferMapper::toResolveRentDto);
    }

}
