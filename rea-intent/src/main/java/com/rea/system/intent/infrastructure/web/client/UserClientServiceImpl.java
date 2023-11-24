package com.rea.system.intent.infrastructure.web.client;


import com.rea.system.intent.domain.port.output.client.UserClientService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import rea.system.common.intent.user.UserIntentPayload;
import rea.system.common.intent.user.UserIntentResponse;
import reactor.core.publisher.Mono;

@Service
public class UserClientServiceImpl implements UserClientService {

    private final WebClient webClient;

    public UserClientServiceImpl(@Qualifier("userClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<UserIntentResponse> getUserIntentResponse(String userId) {
        return webClient.get()
                .uri("/api/user/" + userId)
                .retrieve()
                .bodyToMono(UserIntentResponse.class);
    }

    public Mono<UserIntentResponse> updateUserClient(UserIntentPayload userIntentPayload) {
        return webClient.put()
                .uri("/api/user/update")
                .bodyValue(userIntentPayload)
                .retrieve()
                .bodyToMono(UserIntentResponse.class);
    }

}
