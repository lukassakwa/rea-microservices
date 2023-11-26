package com.rea.system.aggregate.domain.user_offer;

import com.rea.system.aggregate.domain.mail.port.output.MailUserClientService;
import com.rea.system.aggregate.domain.user_offer.core.OfferAggregateEntity;
import com.rea.system.aggregate.domain.user_offer.core.OfferAggregateQuery;
import com.rea.system.aggregate.domain.user_offer.port.output.UserClientService;
import com.rea.system.aggregate.domain.user_offer.port.output.UserOfferClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
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
            LinkedMultiValueMap<String, String> query = OfferAggregateQuery.builder()
                    .estateServiceType(estateServiceType)
                    .offerIds(new HashSet<>(userOffers))
                    .build()
                    .buildQueryParams();
            return userOfferClientService.getUserOffers(query);
        });
    }

}
