package com.rea.system.intent.domain.offer;

import com.rea.system.intent.domain.port.output.client.OfferClientService;
import com.rea.system.intent.infrastructure.web.model.offer.HistoricalOfferIntentResponse;
import com.rea.system.intent.infrastructure.web.model.offer.OfferIntentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;

import static com.rea.system.intent.domain.common.PaginateUtils.DEFAULT_PAGE_SIZE;

@Service
@RequiredArgsConstructor
public class OfferIntentService {

    private final OfferClientService offerClientService;

    public Flux<OfferIntentResponse> getOffers(EstateServiceType estateServiceType,
                                               Integer index,
                                               Integer priceFrom,
                                               Integer priceTo,
                                               Double metersFrom,
                                               Double metersTo) {
        OfferQueryBuilder queryMap = OfferQueryBuilder.builder()
                .estateServiceType(estateServiceType)
                .force(Boolean.TRUE)
                .priceFrom(priceFrom)
                .priceTo(priceTo)
                .metersFrom(metersFrom)
                .metersTo(metersTo)
                .build();
        return offerClientService.getOffers(queryMap.getQuery())
                .skip(index * DEFAULT_PAGE_SIZE)
                .take(DEFAULT_PAGE_SIZE);
    }

    public Flux<HistoricalOfferIntentResponse> getMonitoringData(String offerId, EstateServiceType estateServiceType) {
        return offerClientService.getMonitoringOffers(offerId, estateServiceType);
    }

    public void invokeOfferEngine() {
        offerClientService.invokeOfferEngine();
    }

}
