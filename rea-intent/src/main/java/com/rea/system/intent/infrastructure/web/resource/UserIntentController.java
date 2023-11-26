package com.rea.system.intent.infrastructure.web.resource;

import com.rea.system.intent.domain.user.UserIntentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rea.system.common.intent.offer.OfferIntentResponse;
import rea.system.common.intent.user.UserIntentPayload;
import rea.system.common.intent.user.UserIntentResponse;
import rea.system.common.intent.user_offer.UserOfferIntentPayload;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserIntentController {

    private final UserIntentService userIntentService;

    @GetMapping("/user")
    Mono<UserIntentResponse> users() {
        return userIntentService.getUser();
    }

    @PutMapping("/user/update")
    Mono<UserIntentResponse> users(@RequestBody Mono<UserIntentPayload> userIntentPayload) {
        return userIntentPayload.flatMap(userIntentService::updateUser);
    }

    @PutMapping("/favorite")
    Mono<Void> updateUserFavoriteOffers(@RequestBody Mono<UserOfferIntentPayload> userOfferIntentPayload) {
        return userOfferIntentPayload.flatMap(userIntentService::updateUserOffers);
    }

    @GetMapping("/favorite")
    Flux<OfferIntentResponse> getOffers(@RequestParam EstateServiceType estateServiceType) {
        return userIntentService.getUserOffers(estateServiceType);
    }

}
