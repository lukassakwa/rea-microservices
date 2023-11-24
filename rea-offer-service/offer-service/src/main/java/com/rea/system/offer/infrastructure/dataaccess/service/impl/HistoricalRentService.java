package com.rea.system.offer.infrastructure.dataaccess.service.impl;

import com.rea.system.offer.application.domain.core.DomainOffer;
import com.rea.system.offer.infrastructure.dataaccess.mapper.HistoricalOfferMapper;
import com.rea.system.offer.infrastructure.dataaccess.repository.HistoricalRentRepository;
import com.rea.system.offer.infrastructure.dataaccess.service.HistoricalDomainOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class HistoricalRentService implements HistoricalDomainOfferService {

    private final HistoricalRentRepository historicalRentRepository;
    private final HistoricalOfferMapper historicalOfferMapper;

    @Override
    public Flux<DomainOffer> findByPublicId(String publicId) {
        return historicalRentRepository.findAllByPublicId(publicId)
                .map(historicalOfferMapper::toDomainRentDto);
    }
}
