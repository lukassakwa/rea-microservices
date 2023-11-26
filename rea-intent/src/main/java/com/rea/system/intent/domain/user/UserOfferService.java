package com.rea.system.intent.domain.user;

import rea.system.common.intent.offer.OfferIntentResponse;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

import java.util.Set;

public interface UserOfferService {

    Flux<OfferIntentResponse> getOffers(Set<String> ids, EstateServiceType estateServiceType);

}
