package com.rea.system.user.infrastruture.resource.user_offer;

import com.rea.system.user.domain.port.input.DomainUserOfferService;
import com.rea.system.user.infrastruture.resource.model.UserOfferPayload;
import com.rea.system.user.infrastruture.resource.model.UserOfferResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/favorite")
@RequiredArgsConstructor
public class UserFavoriteOfferController {

    private final DomainUserOfferService domainUserOfferService;
    private final UserOfferIntentMapper userOfferIntentMapper;

    @PutMapping()
    Mono<Void> updateUserFavoriteOffers(@RequestBody Mono<UserOfferPayload> payloadMono) {
        return payloadMono
                .map(userOfferIntentMapper::mapToDomain)
                .flatMap(domainUserOfferService::updateUserOffers)
                .then(Mono.empty());
    }

    @GetMapping("/{userId}")
    Mono<UserOfferResponse> getUserFavoriteOffers(@PathVariable String userId) {
        return domainUserOfferService.getUserOffers(userId)
                .map(UserOfferResponse::new);
    }

}
