package com.rea.system.user.infrastruture.dataaccess;

import com.rea.system.user.infrastruture.dataaccess.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Mono<User> findUserByUserId(String userId);

}
