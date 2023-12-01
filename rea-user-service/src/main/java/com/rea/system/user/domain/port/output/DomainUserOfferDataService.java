package com.rea.system.user.domain.port.output;

import com.rea.system.user.domain.user_offer.core.UserOfferEntity;
import reactor.core.publisher.Mono;

public interface DomainUserOfferDataService {

    Mono<UserOfferEntity> save(UserOfferEntity userOfferEntity);

    Mono<UserOfferEntity> update(UserOfferEntity userOfferEntity);

    Mono<UserOfferEntity> get(String userId);

}
