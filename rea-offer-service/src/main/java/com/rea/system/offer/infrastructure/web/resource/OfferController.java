package com.rea.system.offer.infrastructure.web.resource;

import com.rea.system.offer.application.domain.ports.input.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rea.system.common.dto.OfferDto;
import rea.system.common.model.EstateServiceType;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/offer")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @GetMapping()
    List<OfferDto> getOffers(@RequestParam EstateServiceType estateServiceType,
                             @RequestParam String pageIndex,
                             @RequestParam String pageSize,
                             @RequestParam(required = false) Integer priceFrom,
                             @RequestParam(required = false) Integer priceTo,
                             @RequestParam(required = false) Double metersFrom,
                             @RequestParam(required = false) Double metersTo) {
        return offerService.findOffers(
                estateServiceType,
                Integer.parseInt(pageIndex),
                Integer.parseInt(pageSize),
                priceFrom,
                priceTo,
                metersFrom,
                metersTo
        );
    }

    @GetMapping("/favorite")
    List<OfferDto> getFavorites(@RequestParam EstateServiceType estateServiceType,
                                @RequestParam String pageIndex,
                                @RequestParam String pageSize,
                                @RequestParam Set<String> offerIds,
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
    List<OfferDto> getHistoricalOffers(@PathVariable EstateServiceType estateServiceType,
                                                       @PathVariable String offerId) {
        return offerService.getMonitoringData(offerId, estateServiceType);
    }

}