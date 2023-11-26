package com.rea.system.aggregate.domain.port.output.user_offer;

import reactor.core.publisher.Flux;

public interface UserClientService {

    Flux<String> getUserOfferIds(String userid);

}
