package com.rea.system.app.controllers;

import com.rea.system.app.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rea.system.common.dto.OfferDto;
import rea.system.common.model.EstateServiceType;

@RestController
@RequestMapping("/api/interface/offer")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @GetMapping()
    Page<OfferDto> getOffers(@RequestParam EstateServiceType estateServiceType,
                             @RequestParam String pageIndex,
                             @RequestParam String pageSize,
                             @RequestParam(required = false) Integer priceFrom,
                             @RequestParam(required = false) Integer priceTo,
                             @RequestParam(required = false) Double metersFrom,
                             @RequestParam(required = false) Double metersTo
    ) {
        return offerService.getPaginatedOffers(estateServiceType,
                pageIndex,
                pageSize,
                priceFrom,
                priceTo,
                metersFrom,
                metersTo);
    }

}
