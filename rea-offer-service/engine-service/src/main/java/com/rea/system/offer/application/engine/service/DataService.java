package com.rea.system.offer.application.engine.service;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import reactor.core.publisher.Mono;

public interface DataService {
    Mono<ResolveOffer> upsertOfferAndMoveToHistoricalIfNecessarily(ResolveOffer resolveOffer);

}
