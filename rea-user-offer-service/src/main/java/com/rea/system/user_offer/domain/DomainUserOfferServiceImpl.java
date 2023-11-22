package com.rea.system.user_offer.domain;

import com.rea.system.user_offer.domain.core.UserOfferEntity;
import com.rea.system.user_offer.domain.port.input.DomainUserOfferService;
import com.rea.system.user_offer.domain.port.output.DomainUserOfferDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DomainUserOfferServiceImpl implements DomainUserOfferService {

    private final DomainUserOfferDataService domainUserOfferDataService;
    private final DomainUserOfferMapper domainUserOfferMapper;

    @Override
    public Mono<UserOfferEntity> updateUserOffers(DomainUserOfferPayload userOfferPayload) {
        String userId = userOfferPayload.getUserId();
        Mono<UserOfferEntity> savedEntity = domainUserOfferDataService.get(userId);
        Mono<UserOfferEntity> domainEntity = savedEntity
                .map(userOfferEntity ->
                        domainUserOfferMapper.toEntity(userOfferEntity, userOfferPayload)
                )
                .switchIfEmpty(Mono.just(domainUserOfferMapper.toEntity(userOfferPayload)));
        Mono<UserOfferEntity> updatedEntity = domainEntity.map(UserOfferEntity::updateUserOffers);
        return updatedEntity.flatMap(domainUserOfferDataService::save);
    }

    @Override
    public Flux<String> getUserOffers(String userId) {
        return domainUserOfferDataService.get(userId)
                .map(UserOfferEntity::getUserOffersId)
                .flatMapMany(Flux::fromIterable);
    }
}
