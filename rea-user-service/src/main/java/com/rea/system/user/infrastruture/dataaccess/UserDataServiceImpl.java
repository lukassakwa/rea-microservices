package com.rea.system.user.infrastruture.dataaccess;

import com.rea.system.user.domain.port.output.DomainUserOfferDataService;
import com.rea.system.user.domain.port.output.UserDataService;
import com.rea.system.user.domain.user.core.UserEntity;
import com.rea.system.user.domain.user_offer.core.UserOfferEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserDataServiceImpl implements UserDataService, DomainUserOfferDataService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Flux<UserEntity> getUsers() {
        return userRepository.findAll()
                .map(userMapper::toUserEntity);
    }

    @Override
    public Mono<UserEntity> getUser(String userId) {
        return userRepository.findUserByUserId(userId)
                .map(userMapper::toUserEntity);
    }

    @Override
    public Mono<UserEntity> save(UserEntity userEntity) {
        return userRepository.save(userMapper.toModel(userEntity))
                .map(userMapper::toUserEntity);
    }

    @Override
    public Mono<UserEntity> update(UserEntity userEntity) {
        return userRepository.findUserByUserId(userEntity.getUserId())
                .map(user -> userMapper.update(user, userEntity))
                .flatMap(userRepository::save)
                .map(userMapper::toUserEntity);
    }

    @Override
    public Mono<UserOfferEntity> save(UserOfferEntity userOfferEntity) {
        return userRepository.save(userMapper.toModel(userOfferEntity))
                .map(userMapper::toUserOfferEntity);
    }

    @Override
    public Mono<UserOfferEntity> update(UserOfferEntity userOfferEntity) {
        return userRepository.findUserByUserId(userOfferEntity.getUserId())
                .map(user -> userMapper.update(user, userOfferEntity))
                .flatMap(userRepository::save)
                .map(userMapper::toUserOfferEntity);
    }

    @Override
    public Mono<UserOfferEntity> get(String userId) {
        return userRepository.findUserByUserId(userId)
                .map(userMapper::toUserOfferEntity);
    }
}
