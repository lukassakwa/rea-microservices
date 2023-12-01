package com.rea.system.user.domain.port.input;

import com.rea.system.user.domain.user_offer.core.UserOfferEntity;
import com.rea.system.user.domain.user_offer.DomainUserOfferPayload;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

public interface DomainUserOfferService {

    Mono<UserOfferEntity> updateUserOffers(DomainUserOfferPayload userOfferPayload);

    Mono<Set<String>> getUserOffers(String userId);

}
