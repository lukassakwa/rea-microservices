package com.rea.system.intent.infrastructure.web.client;

import com.rea.system.intent.domain.port.output.client.AggregateClientService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.rea.system.intent.infrastructure.web.model.offer.OfferIntentResponse;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

@Service
public class AggregateClientServiceImpl implements AggregateClientService {

    private final WebClient aggregateWebClient;

    public AggregateClientServiceImpl(
            @Qualifier("aggregateClient") WebClient aggregateWebClient
    ) {
        this.aggregateWebClient = aggregateWebClient;
    }

    @Override
    public Flux<OfferIntentResponse> aggregateUserOffers(String userId, EstateServiceType estateServiceType) {
        return aggregateWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/useroffer/aggregate/" + userId + "/" + estateServiceType)
                        .build())
                .retrieve()
                .bodyToFlux(OfferIntentResponse.class);
    }
}
