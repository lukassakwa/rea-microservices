package com.rea.system.offer.infrastructure.dataaccess.service;

import com.rea.system.offer.application.engine.entity.ResolveOffer;

import java.util.Optional;

public interface AvailableEngineOfferService {

    Optional<ResolveOffer> findByDuplicateKey(String duplicateKey);

    ResolveOffer save(ResolveOffer offer);

    ResolveOffer update(String offerId, ResolveOffer updatedOffer);

}