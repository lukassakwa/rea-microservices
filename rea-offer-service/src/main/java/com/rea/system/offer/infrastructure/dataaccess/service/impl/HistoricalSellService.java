package com.rea.system.offer.infrastructure.dataaccess.service.impl;

import com.rea.system.offer.application.domain.entity.DomainOffer;
import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.HistoricalSellOffer;
import com.rea.system.offer.infrastructure.dataaccess.mapper.HistoricalOfferMapper;
import com.rea.system.offer.infrastructure.dataaccess.repository.HistoricalSellRepository;
import com.rea.system.offer.infrastructure.dataaccess.service.HistoricalDomainOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.HistoricalEngineOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class HistoricalSellService implements HistoricalEngineOfferService, HistoricalDomainOfferService {

    private final HistoricalSellRepository historicalSellRepository;
    private final HistoricalOfferMapper historicalOfferMapper;

    @Override
    public Mono<ResolveOffer> save(ResolveOffer offer) {
        Mono<HistoricalSellOffer> historicalSellOffer = historicalSellRepository.save(historicalOfferMapper.toSellEntity(offer));
        return historicalSellOffer.map(historicalOfferMapper::toResolveSellDto);
    }

    @Override
    public Flux<DomainOffer> findByPublicId(String publicId) {
        return historicalSellRepository.findAllByPublicId(publicId)
                .map(historicalOfferMapper::toDomainSellDto);
    }
}
