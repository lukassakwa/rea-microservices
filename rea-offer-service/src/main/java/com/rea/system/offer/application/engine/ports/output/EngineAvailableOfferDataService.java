package com.rea.system.offer.application.engine.ports.output;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Mono;

public interface EngineAvailableOfferDataService {

    Mono<ResolveOffer> save(ResolveOffer ResolveOffer, EstateServiceType estateServiceType);

    Mono<ResolveOffer> update(String offerId, ResolveOffer updatedResolveOffer, EstateServiceType estateServiceType);

    Mono<ResolveOffer> findByDuplicateKey(String duplicateKey, EstateServiceType estateServiceType);

}