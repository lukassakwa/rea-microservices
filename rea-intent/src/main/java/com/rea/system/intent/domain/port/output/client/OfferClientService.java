package com.rea.system.intent.domain.port.output.client;

import org.springframework.util.LinkedMultiValueMap;
import rea.system.common.intent.offer.HistoricalOfferIntentResponse;
import rea.system.common.intent.offer.OfferIntentResponse;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

public interface OfferClientService {

    Flux<OfferIntentResponse> getOffers(LinkedMultiValueMap<String, String> queryMap);

    Flux<HistoricalOfferIntentResponse> getMonitoringOffers(String offerId, EstateServiceType estateServiceType);

    void invokeOfferEngine();
}
