package com.rea.system.intent.domain.port.output.client;

import rea.system.common.intent.user_offer.UserOfferIntentPayload;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserOfferClientService {

    Mono<Void> updateUserOffers(UserOfferIntentPayload userOfferIntentPayload);

    Flux<String> getUserOfferIds(String userid);

}
