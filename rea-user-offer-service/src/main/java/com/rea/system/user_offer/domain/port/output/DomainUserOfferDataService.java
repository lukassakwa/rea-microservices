package com.rea.system.user_offer.domain.port.output;

import com.rea.system.user_offer.domain.core.UserOfferEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DomainUserOfferDataService {

    Mono<UserOfferEntity> save(UserOfferEntity userOfferEntity);

    Mono<UserOfferEntity> get(String userId);

}
