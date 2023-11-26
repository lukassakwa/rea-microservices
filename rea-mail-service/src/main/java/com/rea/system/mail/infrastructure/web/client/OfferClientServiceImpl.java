package com.rea.system.mail.infrastructure.web.client;

import com.rea.system.mail.domain.core.OfferMailEntity;
import com.rea.system.mail.domain.port.output.OfferClientService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import rea.system.common.mail.OfferMailResponse;
import reactor.core.publisher.Flux;

@Service
public class OfferClientServiceImpl implements OfferClientService {

    private final WebClient webClient;
    private final MailClientMapper mapper;

    public OfferClientServiceImpl(@Qualifier("offerClient") WebClient webClient,
                                  MailClientMapper mapper) {
        this.webClient = webClient;
        this.mapper = mapper;
    }

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

}
