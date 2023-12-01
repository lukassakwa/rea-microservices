package com.rea.system.intent.infrastructure.web.resource;

import com.rea.system.intent.domain.user.UserIntentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.rea.system.intent.infrastructure.web.model.user.UserIntentPayload;
import com.rea.system.intent.infrastructure.web.model.user.UserIntentResponse;
import com.rea.system.intent.infrastructure.web.model.user.UserOfferIntentPayload;
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

}
