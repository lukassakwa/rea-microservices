package com.rea.system.mail.domain.port.output;

import com.rea.system.mail.domain.core.OfferMailEntity;
import org.springframework.util.LinkedMultiValueMap;
import reactor.core.publisher.Flux;

public interface OfferClientService {

    Flux<OfferMailEntity> getOffers(LinkedMultiValueMap<String, String> queryMap);

}
