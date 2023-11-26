package com.rea.system.intent.infrastructure.web.client;

import com.rea.system.intent.domain.port.output.client.OfferClientService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import com.rea.system.intent.infrastructure.web.model.offer.HistoricalOfferIntentResponse;
import com.rea.system.intent.infrastructure.web.model.offer.OfferIntentResponse;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

@Service
public class OfferClientServiceImpl implements OfferClientService {

    private final WebClient offerWebClient;
    private final WebClient offerEngineClient;

    public OfferClientServiceImpl(
            @Qualifier("offerClient") WebClient offerWebClient,
            @Qualifier("offerEngineClient") WebClient offerEngineClient
    ) {
        this.offerWebClient = offerWebClient;
        this.offerEngineClient = offerEngineClient;
    }

    public Flux<OfferIntentResponse> getOffers(LinkedMultiValueMap<String, String> queryMap) {
        return offerWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/offer")
                        .queryParams(queryMap)
                        .build())
                .retrieve()
                .bodyToFlux(OfferIntentResponse.class);
    }

    public Flux<HistoricalOfferIntentResponse> getMonitoringOffers(String offerId, EstateServiceType estateServiceType) {
        return offerWebClient.get()
                .uri("/api/offer/monitor/" + estateServiceType + "/" + offerId)
                .retrieve()
                .bodyToFlux(HistoricalOfferIntentResponse.class);
    }

    @Override
    public void invokeOfferEngine() {
        offerEngineClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/offer/engine")
                        .build())
                .retrieve()
                .bodyToMono(Void.class)
                .subscribe();
    }

}
