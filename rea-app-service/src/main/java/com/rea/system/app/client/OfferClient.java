package com.rea.system.app.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import rea.system.common.dto.OfferDto;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferClient {

    private final WebClient webClient;

    public List<OfferDto> getOffers(MultiValueMap<String, String> params) {
        Mono<OfferDto[]> monoOffers = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/offer")
                        .queryParams(params)
                        .build())
                .retrieve()
                .bodyToMono(OfferDto[].class);

        OfferDto[] offers = monoOffers.block();
        return Arrays.stream(offers).toList();
    }

}
