package com.rea.system.intent.infrastructure.web.resource;

import com.rea.system.intent.domain.user_offer.UserOfferIntentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rea.system.common.intent.offer.OfferIntentResponse;
import rea.system.common.intent.user_offer.UserOfferIntentPayload;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/favorite")
@RequiredArgsConstructor
public class UserOfferController {

    private final UserOfferIntentService userOfferIntentService;

    @PutMapping
    Mono<Void> updateUserFavoriteOffers(@RequestBody Mono<UserOfferIntentPayload> userOfferIntentPayload) {
        return userOfferIntentPayload.flatMap(userOfferIntentService::updateUserOffers);
    }

    @GetMapping()
    Flux<OfferIntentResponse> getOffers(@RequestParam EstateServiceType estateServiceType) {
        return userOfferIntentService.getUserOffers(estateServiceType);
    }

}
