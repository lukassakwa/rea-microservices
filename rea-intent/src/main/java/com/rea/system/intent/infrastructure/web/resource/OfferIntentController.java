package com.rea.system.intent.infrastructure.web.resource;

import com.rea.system.intent.domain.offer.OfferIntentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.rea.system.intent.infrastructure.web.model.offer.HistoricalOfferIntentResponse;
import com.rea.system.intent.infrastructure.web.model.offer.OfferIntentResponse;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/offer")
@RequiredArgsConstructor
public class OfferIntentController {

    private final OfferIntentService offerIntentService;

    @GetMapping()
    Flux<OfferIntentResponse> getOffers(@RequestParam EstateServiceType estateServiceType,
                                        @RequestParam(required = false) Integer priceFrom,
                                        @RequestParam(required = false) Integer priceTo,
                                        @RequestParam(required = false) Double metersFrom,
                                        @RequestParam(required = false) Double metersTo) {
        return offerIntentService.getOffers(estateServiceType,
                priceFrom,
                priceTo,
                metersFrom,
                metersTo);
    }

    @GetMapping("/monitor/{estateServiceType}/{offerId}")
    Flux<HistoricalOfferIntentResponse> getHistoricalOffers(@PathVariable EstateServiceType estateServiceType,
                                                            @PathVariable String offerId) {
        return offerIntentService.getMonitoringData(offerId, estateServiceType);
    }

}
