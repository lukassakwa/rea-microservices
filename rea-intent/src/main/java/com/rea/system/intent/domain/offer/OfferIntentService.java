package com.rea.system.intent.domain.offer;

import com.rea.system.intent.domain.port.output.client.OfferClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import com.rea.system.intent.infrastructure.web.model.offer.HistoricalOfferIntentResponse;
import com.rea.system.intent.infrastructure.web.model.offer.OfferIntentResponse;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class OfferIntentService {

    private final OfferClientService offerClientService;

    public Flux<OfferIntentResponse> getOffers(EstateServiceType estateServiceType,
                                               Integer priceFrom,
                                               Integer priceTo,
                                               Double metersFrom,
                                               Double metersTo) {
        LinkedMultiValueMap<String, String> queryMap = OfferQueryBuilder.builder()
                .estateServiceType(estateServiceType)
                .priceFrom(priceFrom)
                .priceTo(priceTo)
                .metersFrom(metersFrom)
                .metersTo(metersTo)
                .build()
                .buildQueryParams();
        return offerClientService.getOffers(queryMap);
    }

    public Flux<HistoricalOfferIntentResponse> getMonitoringData(String offerId, EstateServiceType estateServiceType) {
        return offerClientService.getMonitoringOffers(offerId, estateServiceType);
    }

    public void invokeOfferEngine() {
        offerClientService.invokeOfferEngine();
    }

}
