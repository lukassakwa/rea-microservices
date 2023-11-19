package com.rea.system.intent.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import rea.system.common.intent.user.UserIntentPayload;
import rea.system.common.intent.user.UserIntentResponse;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserClientService {

    private final WebClient webClient;

    Mono<UserIntentResponse> getUserIntentResponse(String userId) {
        return webClient.get()
                .uri("http://localhost:8084/api/user/" + userId)
                .retrieve()
                .bodyToMono(UserIntentResponse.class);
    }

    Mono<UserIntentResponse> updateUserClient(UserIntentPayload userIntentPayload) {
        return webClient.put()
                .uri("http://localhost:8084/api/user/update")
                .bodyValue(userIntentPayload)
                .retrieve()
                .bodyToMono(UserIntentResponse.class);
    }

}
