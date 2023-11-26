package com.rea.system.user.infrastruture.resource.user;

import com.rea.system.user.infrastruture.resource.model.UserMailResponse;
import com.rea.system.user.infrastruture.resource.model.UserPayload;
import com.rea.system.user.infrastruture.resource.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserIntentService userIntentService;

    @PutMapping("/update")
    Mono<UserResponse> update(@RequestBody Mono<UserPayload> userSettingsIntentPayload) {
        return userSettingsIntentPayload.flatMap(userIntentService::update);
    }

    @GetMapping("/{userId}")
    Mono<UserResponse> getUser(@PathVariable String userId) {
        return userIntentService.getUser(userId);
    }

    @GetMapping("/mail")
    Flux<UserMailResponse> getUser() {
        return userIntentService.getUsers();
    }

}
