package com.rea.system.user.infrastruture.resource.user_offer;

import com.rea.system.user.domain.port.input.DomainUserOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rea.system.common.intent.user_offer.UserOfferIntentPayload;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/favorite")
@RequiredArgsConstructor
public class UserFavoriteOfferController {

    private final DomainUserOfferService domainUserOfferService;
    private final UserOfferIntentMapper userOfferIntentMapper;

    @PutMapping()
    Mono<Void> updateUserFavoriteOffers(@RequestBody Mono<UserOfferIntentPayload> payloadMono) {
        return payloadMono
                .map(userOfferIntentMapper::mapToDomain)
                .flatMap(domainUserOfferService::updateUserOffers)
                .then(Mono.empty());
    }

    @GetMapping("/{userId}")
    Flux<String> getUserFavoriteOffers(@PathVariable String userId) {
        return domainUserOfferService.getUserOffers(userId);
    }

}
