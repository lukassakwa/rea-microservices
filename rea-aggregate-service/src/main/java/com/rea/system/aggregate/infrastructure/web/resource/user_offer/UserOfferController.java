package com.rea.system.aggregate.infrastructure.web.resource.user_offer;

import com.rea.system.aggregate.domain.user_offer.DomainUserOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rea.system.common.aggregate.OfferAggregateResponse;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/useroffer/aggregate")
@RequiredArgsConstructor
public class UserOfferController {

    private final DomainUserOfferService domainUserOfferService;
    private final UserOfferResponseMapper mapper;

    @GetMapping("/{userId}/{estateServiceType}")
    Flux<OfferAggregateResponse> getAggregateOffers(
            @PathVariable EstateServiceType estateServiceType,
            @PathVariable String userId) {
        return domainUserOfferService.aggregateUserOffers(userId, estateServiceType)
                .map(mapper::toResponse);

    }

}
