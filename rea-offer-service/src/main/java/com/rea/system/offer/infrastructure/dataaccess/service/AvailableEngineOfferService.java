package com.rea.system.offer.infrastructure.dataaccess.service;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface AvailableEngineOfferService {

    Mono<ResolveOffer> findByDuplicateKey(String duplicateKey);

    Mono<ResolveOffer> save(ResolveOffer offer);

    Mono<ResolveOffer> update(String offerId, ResolveOffer updatedOffer);

}