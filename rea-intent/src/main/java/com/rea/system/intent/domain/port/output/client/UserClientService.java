package com.rea.system.intent.domain.port.output.client;

import rea.system.common.intent.user.UserIntentPayload;
import rea.system.common.intent.user.UserIntentResponse;
import rea.system.common.intent.user_offer.UserOfferIntentPayload;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserClientService {

    Mono<UserIntentResponse> getUserIntentResponse(String userId);

    Mono<UserIntentResponse> updateUserClient(UserIntentPayload userIntentPayload);

    Mono<Void> updateUserOffers(UserOfferIntentPayload userOfferIntentPayload);

    Flux<String> getUserOfferIds(String userid);

}
