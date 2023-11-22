package com.rea.system.offer.infrastructure.dataaccess.service.impl;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.HistoricalSellOffer;
import com.rea.system.offer.infrastructure.dataaccess.mapper.HistoricalOfferMapper;
import com.rea.system.offer.infrastructure.dataaccess.repository.HistoricalSellRepository;
import com.rea.system.offer.infrastructure.dataaccess.service.HistoricalEngineOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class HistoricalSellService implements HistoricalEngineOfferService {

    private final HistoricalSellRepository historicalSellRepository;
    private final HistoricalOfferMapper historicalOfferMapper;

    @Override
    public Mono<ResolveOffer> save(ResolveOffer offer) {
        Mono<HistoricalSellOffer> historicalSellOffer = historicalSellRepository.save(historicalOfferMapper.toSellEntity(offer));
        return historicalSellOffer.map(historicalOfferMapper::toResolveSellDto);
    }

}
