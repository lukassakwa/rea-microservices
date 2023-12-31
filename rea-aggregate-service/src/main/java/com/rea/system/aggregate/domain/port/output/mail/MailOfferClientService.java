package com.rea.system.aggregate.domain.port.output.mail;

import com.rea.system.aggregate.domain.mail.core.OfferMailEntity;
import org.springframework.util.LinkedMultiValueMap;
import reactor.core.publisher.Flux;

public interface MailOfferClientService {

    Flux<OfferMailEntity> getOffers(LinkedMultiValueMap<String, String> queryMap);

}
