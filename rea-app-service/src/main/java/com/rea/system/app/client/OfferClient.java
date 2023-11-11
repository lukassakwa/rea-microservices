package com.rea.system.app.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import rea.system.common.dto.OfferDto;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class OfferClient {

    private final WebClient webClient;

    public Flux<OfferDto> getOffers(MultiValueMap<String, String> params) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/offer")
                        .queryParams(params)
                        .build())
                .retrieve()
                .bodyToFlux(OfferDto.class);
    }

}
