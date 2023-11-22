package com.rea.system.offer.application.engine.service;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.application.engine.OfferLoadContext;
import reactor.core.publisher.Flux;

public interface AcquisitionReactiveOfferService {

    Flux<ResolveOffer> resolveAllSpecificOffers(OfferLoadContext context);

}
