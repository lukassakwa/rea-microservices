package com.rea.system.offer.infrastructure.dataaccess;

import com.rea.system.offer.application.domain.core.DomainOffer;
import com.rea.system.offer.application.domain.ports.output.DomainHistoricalOfferDataService;
import com.rea.system.offer.infrastructure.dataaccess.service.HistoricalDomainOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class HistoricalOfferServiceProviderImpl implements DomainHistoricalOfferDataService {

    private final OfferServiceResolver resolver;

    @Override
    public Flux<DomainOffer> findByPublicId(String publicId, EstateServiceType estateServiceType) {
        HistoricalDomainOfferService historicalOfferService = resolver.resolveHistoricalDomainOfferService(estateServiceType);
        return historicalOfferService.findByPublicId(publicId);
    }

}