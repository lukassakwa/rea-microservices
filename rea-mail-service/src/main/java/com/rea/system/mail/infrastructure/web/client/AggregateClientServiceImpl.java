package com.rea.system.mail.infrastructure.web.client;

import com.rea.system.mail.domain.core.MailEntity;
import com.rea.system.mail.domain.port.output.AggregateClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import rea.system.common.aggregate.MailUserOfferAggregateResponse;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class AggregateClientServiceImpl implements AggregateClientService {

    private final WebClient webClient;
    private final MailClientMapper mapper;

    public Flux<MailEntity> getAggregateUserOffers() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/mail/aggregate")
                        .build())
                .retrieve()
                .bodyToFlux(MailUserOfferAggregateResponse.class)
                .map(mapper::toEntity);
    }

}
