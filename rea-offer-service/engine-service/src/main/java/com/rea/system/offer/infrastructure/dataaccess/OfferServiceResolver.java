package com.rea.system.offer.infrastructure.dataaccess;

import com.rea.system.offer.infrastructure.dataaccess.service.AvailableEngineOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.HistoricalEngineOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.RentOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.SellOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.model.offer.EstateServiceType;

@Service
@RequiredArgsConstructor
class OfferServiceResolver {

    private final SellOfferService sellOfferService;
    private final RentOfferService rentOfferService;

    AvailableEngineOfferService resolveEngineOfferService(EstateServiceType estateServiceType) {
        return EstateServiceType.RENT.equals(estateServiceType) ? rentOfferService : sellOfferService;
    }

    HistoricalEngineOfferService resolveHistoricalEngineOfferService(EstateServiceType estateServiceType) {
        return EstateServiceType.RENT.equals(estateServiceType) ? rentOfferService : sellOfferService;
    }

}
