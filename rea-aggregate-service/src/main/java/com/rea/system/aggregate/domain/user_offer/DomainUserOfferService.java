package com.rea.system.aggregate.domain.user_offer;

import com.rea.system.aggregate.domain.port.output.user_offer.UserClientService;
import com.rea.system.aggregate.domain.port.output.user_offer.UserOfferClientService;
import com.rea.system.aggregate.domain.user_offer.core.OfferAggregateEntity;
import com.rea.system.aggregate.domain.user_offer.core.OfferAggregateQuery;
import com.rea.system.aggregate.domain.user_offer.core.OfferUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DomainUserOfferService {

    private final UserClientService userClientService;
    private final UserOfferClientService userOfferClientService;

    public Flux<OfferAggregateEntity> aggregateUserOffers(String userId, EstateServiceType estateServiceType) {
        Mono<OfferUserEntity> userOffersId = userClientService.getUserOfferIds(userId)
                .map(OfferUserEntity::validate);
        return userOffersId.flatMapMany(offerUserEntity -> {
            OfferAggregateQuery query = OfferAggregateQuery.builder()
                    .estateServiceType(estateServiceType)
                    .offerIds(offerUserEntity.getUserOffersId())
                    .build();
            return userOfferClientService.getUserOffers(query.getQuery());
        });
    }

}
