package com.rea.system.user.domain.user;

import com.rea.system.user.domain.user.core.UserEntity;
import com.rea.system.user.domain.port.input.DomainUserService;
import com.rea.system.user.domain.port.output.UserDataService;
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
        return userDataService.getUser(userId)
                .map(currentUserSettings -> userMapper.update(currentUserSettings, userEntity))
                .flatMap(userDataService::save)
                .switchIfEmpty(Mono.error(new RuntimeException("users settings does not exist")));
    }

    @Override
    public Mono<UserEntity> getUser(String userId) {
        return userDataService.getUser(userId)
                .switchIfEmpty(Mono.defer(() -> userDataService.save(UserEntity.createDefaultUserSettings(userId))));
    }

    @Override
    public Flux<UserEntity> getUsers() {
        return userDataService.getUsers();
    }
}
