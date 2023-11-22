package com.rea.system.intent.infrastructure.web.resource;

import com.rea.system.intent.domain.user.UserIntentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rea.system.common.intent.user.UserIntentPayload;
import rea.system.common.intent.user.UserIntentResponse;
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
