package com.rea.system.offer.application.engine.ports.output;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Mono;

public interface EngineHistoricalOfferDataService {

    Mono<ResolveOffer> save(ResolveOffer resolveOffer, EstateServiceType estateServiceType);

}
