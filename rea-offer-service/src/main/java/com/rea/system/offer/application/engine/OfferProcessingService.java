package com.rea.system.offer.application.engine;

import com.rea.system.offer.application.engine.model.OfferLoadDto;

public interface OfferProcessingService {

    void process(OfferLoadDto offerLoadDto);

}
