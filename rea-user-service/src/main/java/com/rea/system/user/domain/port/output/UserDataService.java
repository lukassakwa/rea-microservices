package com.rea.system.user.domain.port.output;

import com.rea.system.user.domain.core.UserEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserDataService {

    Flux<UserEntity> getUsers();

    Mono<UserEntity> getUser(String userId);

    Mono<UserEntity> save(UserEntity userEntity);

}
