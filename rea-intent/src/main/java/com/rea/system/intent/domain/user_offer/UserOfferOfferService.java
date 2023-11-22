package com.rea.system.intent.domain.user_offer;

import rea.system.common.intent.offer.OfferIntentResponse;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

import java.util.Set;

public interface UserOfferOfferService {

    Flux<OfferIntentResponse> getOffers(Set<String> ids, EstateServiceType estateServiceType);

}
