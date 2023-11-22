package com.rea.system.user_offer.domain.port.input;

import com.rea.system.user_offer.domain.DomainUserOfferPayload;
import com.rea.system.user_offer.domain.core.UserOfferEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DomainUserOfferService {

    Mono<UserOfferEntity> updateUserOffers(DomainUserOfferPayload userOfferPayload);

    Flux<String> getUserOffers(String userId);

}
