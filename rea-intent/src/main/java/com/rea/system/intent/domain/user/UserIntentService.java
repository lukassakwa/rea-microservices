package com.rea.system.intent.domain.user;

import com.rea.system.intent.domain.port.output.client.UserClientService;
import com.rea.system.intent.domain.port.output.security.UserSecurityAuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rea.system.common.intent.offer.OfferIntentResponse;
import rea.system.common.intent.user.UserIntentPayload;
import rea.system.common.intent.user.UserIntentResponse;
import rea.system.common.intent.user_offer.UserOfferIntentPayload;
import rea.system.common.model.offer.EstateServiceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserIntentService {

    private final UserClientService userClientService;
    private final UserIntentMapper userIntentMapper;
    private final UserSecurityAuthenticationService securityAuthenticationService;
    private final UserOfferService userOfferService;

    public Mono<UserIntentResponse> getUser() {
        return securityAuthenticationService.getUserId()
                .flatMap(userClientService::getUserIntentResponse);
    }

    public Mono<UserIntentResponse> updateUser(UserIntentPayload payload) {
        Mono<String> userId = securityAuthenticationService.getUserId();
        Mono<String> username = securityAuthenticationService.getUsername();
        return Mono.zip(userId, username)
                .map(tuple -> userIntentMapper.update(
                        tuple.getT1(),
                        tuple.getT2(),
                        payload)
                )
                .flatMap(userClientService::updateUserClient);
    }

    public Mono<Void> updateUserOffers(UserOfferIntentPayload userOfferIntentPayload) {
        Mono<String> userId = securityAuthenticationService.getUserId();
        return userId
                .map(id -> userIntentMapper.toPayload(id, userOfferIntentPayload))
                .flatMap(userClientService::updateUserOffers);
    }

    public Flux<OfferIntentResponse> getUserOffers(EstateServiceType estateServiceType) {
        Mono<String> userId = securityAuthenticationService.getUserId();
        Mono<List<String>> userOffersId = userId
                .flatMapMany(userClientService::getUserOfferIds)
                .collectList();
        return userOffersId.flatMapMany(userOffers ->
                userOfferService.getOffers(new HashSet<>(userOffers), estateServiceType)
        );
    }


}
