package com.rea.system.offer.infrastructure.dataaccess;

import com.rea.system.offer.infrastructure.dataaccess.service.AvailableDomainOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.impl.RentOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.AvailableEngineOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.impl.SellOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.model.EstateServiceType;

@Service
@RequiredArgsConstructor
class OfferServiceResolver {

    private final SellOfferService sellOfferService;
    private final RentOfferService rentOfferService;

    AvailableEngineOfferService resolveEngineOfferService(EstateServiceType estateServiceType) {
        return EstateServiceType.RENT.equals(estateServiceType) ? rentOfferService : sellOfferService;
    }

    AvailableDomainOfferService resolveDomainOfferService(EstateServiceType estateServiceType) {
        return EstateServiceType.RENT.equals(estateServiceType) ? rentOfferService : sellOfferService;
    }

}
