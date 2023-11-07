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

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistoricalSellService implements HistoricalEngineOfferService, HistoricalDomainOfferService {

    private final HistoricalSellRepository historicalSellRepository;
    private final HistoricalOfferMapper historicalOfferMapper;

    @Override
    public ResolveOffer save(ResolveOffer offer) {
        HistoricalSellOffer historicalSellOffer = historicalSellRepository.save(historicalOfferMapper.toSellEntity(offer));
        return historicalOfferMapper.toResolveSellDto(historicalSellOffer);
    }

    @Override
    public List<DomainOffer> findByPublicId(String publicId) {
        return historicalSellRepository.findAllByPublicId(publicId).stream()
                .map(historicalOfferMapper::toDomainSellDto)
                .collect(Collectors.toList());
    }
}
