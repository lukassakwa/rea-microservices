package com.rea.system.intent.offer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import rea.system.common.intent.offer.HistoricalOfferIntentResponse;
import rea.system.common.intent.offer.OfferIntentResponse;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class OfferClientService {

    private final WebClient webClient;

    Flux<OfferIntentResponse> getOffers(LinkedMultiValueMap<String, String> queryMap) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host("localhost")
                        .port("8083")
                        .path("/api/offer")
                        .queryParams(queryMap)
                        .build())
                .retrieve()
                .bodyToFlux(OfferIntentResponse.class);
    }

    Flux<HistoricalOfferIntentResponse> getMonitoringOffers(String offerId, EstateServiceType estateServiceType) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host("localhost")
                        .port("8083")
                        .path("/api/offer/monitor/" + estateServiceType + "/" + offerId)
                        .build())
                .retrieve()
                .bodyToFlux(HistoricalOfferIntentResponse.class);
    }
}
