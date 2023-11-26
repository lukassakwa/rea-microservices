package com.rea.system.aggregate.infrastructure.web.client;

import com.rea.system.aggregate.domain.mail.core.OfferMailEntity;
import com.rea.system.aggregate.domain.mail.port.output.MailOfferClientService;
import com.rea.system.aggregate.domain.user_offer.core.OfferAggregateEntity;
import com.rea.system.aggregate.domain.user_offer.port.output.UserOfferClientService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import rea.system.common.aggregate.OfferAggregateResponse;
import rea.system.common.aggregate.OfferMailResponse;
import reactor.core.publisher.Flux;

@Service
public class OfferClientServiceImpl implements MailOfferClientService, UserOfferClientService {

    private final WebClient webClient;
    private final UserOfferClientMapper mapper;

    public OfferClientServiceImpl(@Qualifier("offerClient") WebClient webClient,
                                  UserOfferClientMapper mapper) {
        this.webClient = webClient;
        this.mapper = mapper;
    }

    @Override
    public Flux<OfferMailEntity> getOffers(LinkedMultiValueMap<String, String> queryMap) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/offer")
                        .queryParams(queryMap)
                        .build())
                .retrieve()
                .bodyToFlux(OfferMailResponse.class)
                .map(mapper::toEntity);
    }


    @Override
    public Flux<OfferAggregateEntity> getUserOffers(LinkedMultiValueMap<String, String> queryMap) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/offer")
                        .queryParams(queryMap)
                        .build())
                .retrieve()
                .bodyToFlux(OfferAggregateResponse.class)
                .map(mapper::toEntity);
    }
}
