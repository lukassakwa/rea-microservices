package com.rea.system.offer.infrastructure.dataaccess;

import com.rea.system.offer.infrastructure.dataaccess.service.AvailableDomainOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.HistoricalDomainOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.impl.HistoricalRentService;
import com.rea.system.offer.infrastructure.dataaccess.service.impl.HistoricalSellService;
import com.rea.system.offer.infrastructure.dataaccess.service.impl.RentOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.impl.SellOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.model.offer.EstateServiceType;

@Service
@RequiredArgsConstructor
class OfferServiceResolver {

    private final SellOfferService sellOfferService;
    private final RentOfferService rentOfferService;
    private final HistoricalSellService historicalSellService;
    private final HistoricalRentService historicalRentService;

    AvailableDomainOfferService resolveDomainOfferService(EstateServiceType estateServiceType) {
        return EstateServiceType.RENT.equals(estateServiceType) ? rentOfferService : sellOfferService;
    }

    HistoricalDomainOfferService resolveHistoricalDomainOfferService(EstateServiceType estateServiceType) {
        return EstateServiceType.RENT.equals(estateServiceType) ? historicalRentService : historicalSellService;
    }

}
