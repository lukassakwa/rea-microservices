package com.rea.system.user_offer.dataaccess;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserOfferRepository extends ReactiveMongoRepository<UserOffer, String> {

    Mono<UserOffer> findUserOfferByUserId(String userId);

}
