package com.rea.system.intent.domain.port.output.client;

import org.springframework.util.LinkedMultiValueMap;
import com.rea.system.intent.infrastructure.web.model.offer.HistoricalOfferIntentResponse;
import com.rea.system.intent.infrastructure.web.model.offer.OfferIntentResponse;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

public interface OfferClientService {

    Flux<OfferIntentResponse> getOffers(LinkedMultiValueMap<String, String> queryMap);

    Flux<HistoricalOfferIntentResponse> getMonitoringOffers(String offerId, EstateServiceType estateServiceType);

    void invokeOfferEngine();
}
