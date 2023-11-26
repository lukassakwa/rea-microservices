package com.rea.system.intent.domain.offer;

import com.rea.system.intent.domain.port.output.client.OfferClientService;
import com.rea.system.intent.domain.user.UserOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import rea.system.common.intent.offer.HistoricalOfferIntentResponse;
import rea.system.common.intent.offer.OfferIntentResponse;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class OfferIntentService implements UserOfferService {

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

    @Override
    public Flux<OfferIntentResponse> getOffers(Set<String> ids, EstateServiceType estateServiceType) {
        LinkedMultiValueMap<String, String> queryMap = OfferQueryBuilder.builder()
                .estateServiceType(estateServiceType)
                .offerIds(ids)
                .build()
                .buildQueryParams();
        return offerClientService.getOffers(queryMap);
    }
}
