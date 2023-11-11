package com.rea.system.offer.infrastructure.dataaccess;

import com.rea.system.offer.application.domain.entity.DomainOffer;
import com.rea.system.offer.application.domain.ports.output.DomainHistoricalOfferDataService;
import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.application.engine.ports.output.EngineHistoricalOfferDataService;
import com.rea.system.offer.infrastructure.dataaccess.service.HistoricalDomainOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.HistoricalEngineOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.model.EstateServiceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoricalOfferServiceProviderImpl implements EngineHistoricalOfferDataService, DomainHistoricalOfferDataService {

    private final HistoricalOfferServiceResolver resolver;

    @Override
    public Mono<ResolveOffer> save(ResolveOffer resolveOffer, EstateServiceType estateServiceType) {
        HistoricalEngineOfferService historicalOfferService = resolver.resolveEngineOfferService(estateServiceType);
        return historicalOfferService.save(resolveOffer);
    }

    @Override
    public Flux<DomainOffer> findByPublicId(String publicId, EstateServiceType estateServiceType) {
        HistoricalDomainOfferService historicalOfferService = resolver.resolveDomainOfferService(estateServiceType);
        return historicalOfferService.findByPublicId(publicId);
    }

}