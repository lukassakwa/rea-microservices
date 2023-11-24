package com.rea.system.intent.domain.user_offer;

import com.rea.system.intent.domain.port.output.client.UserOfferClientService;
import com.rea.system.intent.domain.port.output.security.UserOfferSecurityAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rea.system.common.intent.offer.OfferIntentResponse;
import rea.system.common.intent.user_offer.UserOfferIntentPayload;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserOfferIntentService {

    private final UserOfferClientService userOfferClientService;
    private final UserOfferOfferService userOfferOfferService;
    private final UserOfferSecurityAuthenticationService securityAuthenticationService;
    private final UserOfferIntentMapper userOfferIntentMapper;

    public Mono<Void> updateUserOffers(UserOfferIntentPayload userOfferIntentPayload) {
        Mono<String> userId = securityAuthenticationService.getUserId();
        return userId
                .map(id -> userOfferIntentMapper.toPayload(id, userOfferIntentPayload))
                .flatMap(userOfferClientService::updateUserOffers);
    }

    public Flux<OfferIntentResponse> getUserOffers(EstateServiceType estateServiceType) {
        Mono<String> userId = securityAuthenticationService.getUserId();
        Mono<List<String>> userOffersId = userId
                .flatMapMany(userOfferClientService::getUserOfferIds)
                .collectList();
        return userOffersId.flatMapMany(userOffers ->
                userOfferOfferService.getOffers(new HashSet<>(userOffers), estateServiceType)
        );
    }

}
