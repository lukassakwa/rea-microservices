package com.rea.system.intent.domain.port.output.client;

import com.rea.system.intent.infrastructure.web.model.offer.OfferIntentResponse;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

public interface AggregateClientService {

    Flux<OfferIntentResponse> aggregateUserOffers(String userId, EstateServiceType estateServiceType);

}
