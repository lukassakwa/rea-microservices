package com.rea.system.offer.application.engine.ports.output;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import rea.system.common.model.EstateServiceType;

import java.util.Optional;

public interface EngineAvailableOfferDataService {

    ResolveOffer save(ResolveOffer ResolveOffer, EstateServiceType estateServiceType);

    ResolveOffer update(String offerId, ResolveOffer updatedResolveOffer, EstateServiceType estateServiceType);

    Optional<ResolveOffer> findByDuplicateKey(String duplicateKey, EstateServiceType estateServiceType);

}