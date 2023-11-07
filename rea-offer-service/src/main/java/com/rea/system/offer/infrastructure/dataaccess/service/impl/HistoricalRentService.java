package com.rea.system.offer.infrastructure.dataaccess.service.impl;

import com.rea.system.offer.application.domain.entity.DomainOffer;
import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.HistoricalRentOffer;
import com.rea.system.offer.infrastructure.dataaccess.mapper.HistoricalOfferMapper;
import com.rea.system.offer.infrastructure.dataaccess.repository.HistoricalRentRepository;
import com.rea.system.offer.infrastructure.dataaccess.service.HistoricalDomainOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.HistoricalEngineOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistoricalRentService implements HistoricalEngineOfferService, HistoricalDomainOfferService {

    private final HistoricalRentRepository historicalRentRepository;
    private final HistoricalOfferMapper historicalOfferMapper;

    @Override
    public ResolveOffer save(ResolveOffer offer) {
        HistoricalRentOffer historicalRentOffer = historicalRentRepository.save(historicalOfferMapper.toRentEntity(offer));
        return historicalOfferMapper.toResolveRentDto(historicalRentOffer);
    }

    @Override
    public List<DomainOffer> findByPublicId(String publicId) {
        return historicalRentRepository.findAllByPublicId(publicId).stream()
                .map(historicalOfferMapper::toDomainRentDto)
                .collect(Collectors.toList());
    }
}
