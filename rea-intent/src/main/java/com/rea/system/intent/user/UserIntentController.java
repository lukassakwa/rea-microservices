package com.rea.system.intent.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import rea.system.common.intent.user.UserIntentPayload;
import rea.system.common.intent.user.UserIntentResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserIntentController {

    private final UserIntentService userIntentService;

    @GetMapping()
    Mono<UserIntentResponse> users() {
        return userIntentService.getUser();
    }

    @PutMapping("update")
    Mono<UserIntentResponse> users(@RequestBody Mono<UserIntentPayload> userIntentPayload) {
        return userIntentPayload.flatMap(userIntentService::updateUser);
    }

}
