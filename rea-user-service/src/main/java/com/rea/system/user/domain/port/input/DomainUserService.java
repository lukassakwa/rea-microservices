package com.rea.system.user.domain.port.input;

import com.rea.system.user.domain.core.UserEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DomainUserService {

    Mono<UserEntity> update(UserEntity userEntity);

    Mono<UserEntity> getUser(String userId);

    Flux<UserEntity> getUsers();

}
