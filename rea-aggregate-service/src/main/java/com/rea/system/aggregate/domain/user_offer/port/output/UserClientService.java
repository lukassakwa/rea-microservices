package com.rea.system.aggregate.domain.user_offer.port.output;

import reactor.core.publisher.Flux;

public interface UserClientService {

    Flux<String> getUserOfferIds(String userid);

}
