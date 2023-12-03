package com.rea.system.offer.infrastructure.dataaccess.service;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import reactor.core.publisher.Mono;

public interface HistoricalEngineOfferService {

    Mono<ResolveOffer> saveHistorical(ResolveOffer offerDto);

}
