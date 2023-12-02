package com.rea.system.offer.application.engine.service.acquisition;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.application.engine.OfferLoadContext;
import reactor.core.publisher.Flux;

public interface AcquisitionOfferService {

    Flux<ResolveOffer> resolveAllSpecificOffers(OfferLoadContext context);

}
