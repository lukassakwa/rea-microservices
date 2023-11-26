package com.rea.system.intent.domain.port.output.client;

import com.rea.system.intent.infrastructure.web.model.user.UserIntentPayload;
import com.rea.system.intent.infrastructure.web.model.user.UserIntentResponse;
import com.rea.system.intent.infrastructure.web.model.user.UserOfferIntentPayload;
import reactor.core.publisher.Mono;

public interface UserClientService {

    Mono<UserIntentResponse> getUserIntentResponse(String userId);

    Mono<UserIntentResponse> updateUserClient(UserIntentPayload userIntentPayload);

    Mono<Void> updateUserOffers(UserOfferIntentPayload userOfferIntentPayload);

}
