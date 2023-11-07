package com.rea.system.offer.application.engine.ports.output;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import rea.system.common.model.EstateServiceType;

public interface EngineHistoricalOfferDataService {

    ResolveOffer save(ResolveOffer resolveOffer, EstateServiceType estateServiceType);

}
