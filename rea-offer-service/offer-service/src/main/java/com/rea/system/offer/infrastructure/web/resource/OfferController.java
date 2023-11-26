package com.rea.system.offer.infrastructure.web.resource;

import com.rea.system.offer.application.domain.ports.input.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rea.system.common.intent.offer.HistoricalOfferIntentResponse;
import rea.system.common.intent.offer.OfferIntentResponse;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

import java.util.Set;

@RestController
@RequestMapping("/api/offer")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;
    private final OfferResponseMapper offerResponseMapper;

    @GetMapping()
    Flux<OfferIntentResponse> getOffers(@RequestParam EstateServiceType estateServiceType,
                                        @RequestParam(required = false) Integer priceFrom,
                                        @RequestParam(required = false) Integer priceTo,
                                        @RequestParam(required = false) Double metersFrom,
                                        @RequestParam(required = false) Double metersTo,
                                        @RequestParam(required = false) Set<String> userOfferIds) {
        return offerService.findOffers(
                estateServiceType,
                priceFrom,
                priceTo,
                metersFrom,
                metersTo,
                userOfferIds
        ).map(offerResponseMapper::toResponse);
    }

    @GetMapping("/monitor/{estateServiceType}/{offerId}")
    Flux<HistoricalOfferIntentResponse> getHistoricalOffers(@PathVariable EstateServiceType estateServiceType,
                                                            @PathVariable String offerId) {
        return offerService.getMonitoringData(offerId, estateServiceType)
                .map(offerResponseMapper::toHistoricalResponse);
    }

}