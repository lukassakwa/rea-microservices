package com.rea.system.aggregate.domain.user_offer;

import com.rea.system.aggregate.domain.user_offer.core.OfferAggregateEntity;
import com.rea.system.aggregate.domain.user_offer.core.OfferAggregateQuery;
import com.rea.system.aggregate.domain.port.output.user_offer.UserClientService;
import com.rea.system.aggregate.domain.port.output.user_offer.UserOfferClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainUserOfferService {

    private final UserClientService userClientService;
    private final UserOfferClientService userOfferClientService;

    public Flux<OfferAggregateEntity> aggregateUserOffers(String userId, EstateServiceType estateServiceType) {
        Mono<List<String>> userOffersId = userClientService.getUserOfferIds(userId)
                .collectList();
        return userOffersId.flatMapMany(userOffers -> {
            OfferAggregateQuery query = OfferAggregateQuery.builder()
                    .estateServiceType(estateServiceType)
                    .offerIds(new HashSet<>(userOffers))
                    .build();
            return userOfferClientService.getUserOffers(query.getQuery());
        });
    }

}
