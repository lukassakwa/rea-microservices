package com.rea.system.intent.domain.aggregate;

import com.rea.system.intent.domain.port.output.client.AggregateClientService;
import com.rea.system.intent.domain.port.output.security.UserSecurityAuthenticationService;
import com.rea.system.intent.infrastructure.web.model.offer.OfferIntentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.rea.system.intent.domain.common.PaginateUtils.DEFAULT_PAGE_SIZE;

@Service
@RequiredArgsConstructor
public class AggregateIntentService {

    private final AggregateClientService aggregateClientService;
    private final UserSecurityAuthenticationService securityAuthenticationService;

    public Flux<OfferIntentResponse> getUserOffers(EstateServiceType estateServiceType, Integer index) {
        Mono<String> userId = securityAuthenticationService.getUserId();
        return userId.flatMapMany(id -> aggregateClientService.aggregateUserOffers(id, estateServiceType))
                .skip(index * DEFAULT_PAGE_SIZE)
                .take(DEFAULT_PAGE_SIZE);
    }

}
