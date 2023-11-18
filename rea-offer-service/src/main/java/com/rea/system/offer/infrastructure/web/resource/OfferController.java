package com.rea.system.offer.infrastructure.web.resource;

import com.rea.system.offer.application.domain.ports.input.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rea.system.common.dto.offer.OfferDto;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

import java.util.Set;

@RestController
@RequestMapping("/api/offer")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @GetMapping()
    Flux<OfferDto> getOffers(@RequestParam EstateServiceType estateServiceType,
                             @RequestParam String pageIndex,
                             @RequestParam String pageSize,
                             @RequestParam(required = false) Set<String> offerIds,
                             @RequestParam(required = false) Integer priceFrom,
                             @RequestParam(required = false) Integer priceTo,
                             @RequestParam(required = false) Double metersFrom,
                             @RequestParam(required = false) Double metersTo) {
        return offerService.findOffers(
                estateServiceType,
                offerIds,
                Integer.parseInt(pageIndex),
                Integer.parseInt(pageSize),
                priceFrom,
                priceTo,
                metersFrom,
                metersTo
        );
    }

    @GetMapping("/monitor/{estateServiceType}/{offerId}")
    Flux<OfferDto> getHistoricalOffers(@PathVariable EstateServiceType estateServiceType,
                                                       @PathVariable String offerId) {
        return offerService.getMonitoringData(offerId, estateServiceType);
    }

}