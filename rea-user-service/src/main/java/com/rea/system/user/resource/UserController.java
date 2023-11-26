package com.rea.system.user.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rea.system.common.intent.user.UserIntentPayload;
import rea.system.common.intent.user.UserIntentResponse;
import rea.system.common.mail.UserMailResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserIntentService userIntentService;

    @PutMapping("/update")
    Mono<UserIntentResponse> update(@RequestBody Mono<UserIntentPayload> userSettingsIntentPayload) {
        return userSettingsIntentPayload.flatMap(userIntentService::update);
    }

    @GetMapping("/{userId}")
    Mono<UserIntentResponse> getUser(@PathVariable String userId) {
        return userIntentService.getUser(userId);
    }

    @GetMapping("/mail")
    Flux<UserMailResponse> getUser() {
        return userIntentService.getUsers();
    }

}
