package com.rea.system.offer.infrastructure.dataaccess;

import com.rea.system.offer.infrastructure.dataaccess.service.HistoricalDomainOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.HistoricalEngineOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.impl.HistoricalRentService;
import com.rea.system.offer.infrastructure.dataaccess.service.impl.HistoricalSellService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.model.EstateServiceType;

@Service
@RequiredArgsConstructor
class HistoricalOfferServiceResolver {

    private final HistoricalSellService historicalSellService;
    private final HistoricalRentService historicalRentService;

    HistoricalEngineOfferService resolveEngineOfferService(EstateServiceType estateServiceType) {
        return EstateServiceType.RENT.equals(estateServiceType) ? historicalRentService : historicalSellService;
    }

    HistoricalDomainOfferService resolveDomainOfferService(EstateServiceType estateServiceType) {
        return EstateServiceType.RENT.equals(estateServiceType) ? historicalRentService : historicalSellService;
    }

}
