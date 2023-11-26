package com.rea.system.intent.domain.port.output.client;

import rea.system.common.intent.offer.OfferIntentResponse;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

public interface AggregateClientService {

    Flux<OfferIntentResponse> aggregateUserOffers(String userId, EstateServiceType estateServiceType);

}
