package com.rea.system.intent.domain.aggregate;

import com.rea.system.intent.domain.port.output.client.AggregateClientService;
import com.rea.system.intent.domain.port.output.security.UserSecurityAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.intent.offer.OfferIntentResponse;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AggregateIntentService {

    private final AggregateClientService aggregateClientService;
    private final UserSecurityAuthenticationService securityAuthenticationService;

    public Flux<OfferIntentResponse> getUserOffers(EstateServiceType estateServiceType) {
        Mono<String> userId = securityAuthenticationService.getUserId();
        return userId.flatMapMany(id -> aggregateClientService.aggregateUserOffers(id, estateServiceType));
    }

}
