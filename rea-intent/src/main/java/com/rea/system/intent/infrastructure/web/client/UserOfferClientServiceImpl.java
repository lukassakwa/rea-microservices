package com.rea.system.intent.infrastructure.web.client;

import com.rea.system.intent.domain.port.output.client.UserOfferClientService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import rea.system.common.intent.user_offer.UserOfferIntentPayload;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserOfferClientServiceImpl implements UserOfferClientService {

    private final WebClient webClient;

    public UserOfferClientServiceImpl(@Qualifier("userOfferClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Void> updateUserOffers(UserOfferIntentPayload userOfferIntentPayload) {
        return webClient.put()
                .uri("/api/favorite")
                .bodyValue(userOfferIntentPayload)
                .retrieve()
                .bodyToMono(Void.class);
    }

    public Flux<String> getUserOfferIds(String userid) {
        return webClient.get()
                .uri("/api/favorite/" + userid)
                .retrieve()
                .bodyToFlux(String.class);
    }

}
