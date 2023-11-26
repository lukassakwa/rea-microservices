package com.rea.system.user.domain.user_offer;

import com.rea.system.user.domain.port.input.DomainUserOfferService;
import com.rea.system.user.domain.port.output.DomainUserOfferDataService;
import com.rea.system.user.domain.user_offer.core.UserOfferEntity;
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
