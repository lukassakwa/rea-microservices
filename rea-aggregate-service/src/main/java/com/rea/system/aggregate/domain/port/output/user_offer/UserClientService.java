package com.rea.system.aggregate.domain.port.output.user_offer;

import com.rea.system.aggregate.domain.user_offer.core.OfferUserEntity;
import reactor.core.publisher.Mono;

public interface UserClientService {

    Mono<OfferUserEntity> getUserOfferIds(String userid);

}
