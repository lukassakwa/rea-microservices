package com.rea.system.user.domain.user;

import com.rea.system.user.domain.port.input.DomainUserService;
import com.rea.system.user.domain.port.output.UserDataService;
import com.rea.system.user.domain.user.core.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DomainUserServiceImpl implements DomainUserService {

    private final UserDataService userDataService;
    private final DomainUserMapper userMapper;

    @Override
    public Mono<UserEntity> update(UserEntity userEntity) {
        String userId = userEntity.getUserId();
        return getUser(userId)
                .map(entity -> userMapper.update(entity, userEntity))
                .flatMap(userDataService::update);
    }

    @Override
    public Mono<UserEntity> getUser(String userId) {
        return userDataService.getUser(userId)
                .switchIfEmpty(userDataService.save(UserEntity.userEntityWithUserId(userId)));
    }

    @Override
    public Flux<UserEntity> getUsers() {
        return userDataService.getUsers();
    }
}
