package com.rea.system.user.dataaccess;

import com.rea.system.user.domain.core.UserEntity;
import com.rea.system.user.domain.port.output.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserDataServiceImpl implements UserDataService {

    private final UserRepository userSettingsRepository;
    private final UserMapper userMapper;

    @Override
    public Flux<UserEntity> getUsers() {
        return userSettingsRepository.findAll()
                .map(userMapper::toEntity);
    }

    @Override
    public Mono<UserEntity> getUser(String userId) {
        return userSettingsRepository.getUserByUserId(userId)
                .map(userMapper::toEntity);
    }

    @Override
    public Mono<UserEntity> save(UserEntity userEntity) {
        return userSettingsRepository.save(userMapper.toModel(userEntity))
                .map(userMapper::toEntity);
    }
}
