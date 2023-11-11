package com.rea.system.offer.application.engine.service;

import com.rea.system.offer.application.engine.entity.ResolveOffer;

public interface DataService {
    void upsertOfferAndMoveToHistoricalIfNecessarily(ResolveOffer resolveOffer);

}
