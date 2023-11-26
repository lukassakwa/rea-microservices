package com.rea.system.mail.infrastructure.web.client;

import com.rea.system.mail.domain.core.UserMailEntity;
import com.rea.system.mail.domain.port.output.UserClientService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import rea.system.common.mail.UserMailResponse;
import reactor.core.publisher.Flux;

@Service
public class UserClientServiceImpl implements UserClientService {

    private final WebClient webClient;
    private final MailClientMapper mapper;

    public UserClientServiceImpl(@Qualifier("userClient") WebClient webClient,
                                 MailClientMapper mapper) {
        this.webClient = webClient;
        this.mapper = mapper;
    }

    public Flux<UserMailEntity> getUsers() {
        return webClient.get()
                .uri("/api/user/mail")
                .retrieve()
                .bodyToFlux(UserMailResponse.class)
                .map(mapper::toEntity);
    }

}
