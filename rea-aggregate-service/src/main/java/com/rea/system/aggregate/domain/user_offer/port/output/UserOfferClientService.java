package com.rea.system.aggregate.domain.user_offer.port.output;

import com.rea.system.aggregate.domain.user_offer.core.OfferAggregateEntity;
import org.springframework.util.LinkedMultiValueMap;
import reactor.core.publisher.Flux;

public interface UserOfferClientService {

    Flux<OfferAggregateEntity> getUserOffers(LinkedMultiValueMap<String, String> queryMap);

}
