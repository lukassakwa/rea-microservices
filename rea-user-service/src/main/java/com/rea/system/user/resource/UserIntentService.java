package com.rea.system.user.resource;

import com.rea.system.user.domain.port.input.DomainUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.intent.user.UserIntentPayload;
import rea.system.common.intent.user.UserIntentResponse;
import rea.system.common.mail.UserMailResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserIntentService {

    private final DomainUserService domainUserService;
    private final UserIntentMapper userIntentMapper;

    Flux<UserMailResponse> getUsers() {
        return domainUserService.getUsers()
                .map(userIntentMapper::toMailResponse);
    }

    Mono<UserIntentResponse> getUser(String userId) {
        return domainUserService.getUser(userId)
                .map(userIntentMapper::toIntentResponse);
    }

    Mono<UserIntentResponse> update(UserIntentPayload userIntentPayload) {
        return domainUserService.update(userIntentMapper.toEntity(userIntentPayload))
                .map(userIntentMapper::toIntentResponse);
    }

}
