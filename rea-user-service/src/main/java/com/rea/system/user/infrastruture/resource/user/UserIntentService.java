package com.rea.system.user.infrastruture.resource.user;

import com.rea.system.user.domain.port.input.DomainUserService;
import com.rea.system.user.infrastruture.resource.model.UserMailResponse;
import com.rea.system.user.infrastruture.resource.model.UserPayload;
import com.rea.system.user.infrastruture.resource.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

    Mono<UserResponse> getUser(String userId) {
        return domainUserService.getUser(userId)
                .map(userIntentMapper::toIntentResponse);
    }

    Mono<UserResponse> update(UserPayload userIntentPayload) {
        return domainUserService.update(userIntentMapper.toEntity(userIntentPayload))
                .map(userIntentMapper::toIntentResponse);
    }

}
