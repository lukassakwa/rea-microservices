package com.rea.system.aggregate.infrastructure.web.client;

import com.rea.system.aggregate.domain.mail.core.UserMailEntity;
import com.rea.system.aggregate.domain.port.output.mail.MailUserClientService;
import com.rea.system.aggregate.domain.port.output.user_offer.UserClientService;
import com.rea.system.aggregate.domain.user_offer.core.OfferUserEntity;
import com.rea.system.aggregate.infrastructure.web.model.UserOfferResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.rea.system.aggregate.infrastructure.web.model.UserMailResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserClientServiceImpl implements MailUserClientService, UserClientService {

    private final WebClient webClient;
    private final UserOfferClientMapper mapper;

    public UserClientServiceImpl(@Qualifier("userClient") WebClient webClient,
                                 UserOfferClientMapper mapper) {
        this.webClient = webClient;
        this.mapper = mapper;
    }

    @Override
    public Flux<UserMailEntity> getUsers() {
        return webClient.get()
                .uri("/api/user/mail")
                .retrieve()
                .bodyToFlux(UserMailResponse.class)
                .map(mapper::toEntity);
    }


    @Override
    public Mono<OfferUserEntity> getUserOfferIds(String userid) {
        return webClient.get()
                .uri("/api/favorite/" + userid)
                .retrieve()
                .bodyToMono(UserOfferResponse.class)
                .map(mapper::toEntity);
    }
}
