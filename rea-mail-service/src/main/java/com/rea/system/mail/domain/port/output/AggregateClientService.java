package com.rea.system.mail.domain.port.output;

import com.rea.system.mail.domain.core.MailEntity;
import org.springframework.util.LinkedMultiValueMap;
import reactor.core.publisher.Flux;

public interface AggregateClientService {

    Flux<MailEntity> getAggregateUserOffers();

}
