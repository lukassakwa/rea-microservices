package com.rea.system.user.domain.user_offer;

import com.rea.system.user.domain.port.input.DomainUserOfferService;
import com.rea.system.user.domain.port.output.DomainUserOfferDataService;
import com.rea.system.user.domain.user_offer.core.UserOfferEntity;
import lombok.RequiredArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DomainUserOfferServiceImpl implements DomainUserOfferService {

    private final DomainUserOfferDataService domainUserOfferDataService;
    private final DomainUserOfferMapper domainUserOfferMapper;

    @Override
    public Mono<UserOfferEntity> updateUserOffers(DomainUserOfferPayload userOfferPayload) {
        String userId = userOfferPayload.getUserId();
        Mono<UserOfferEntity> savedEntity = getOrCreate(userId);
        Mono<UserOfferEntity> domainEntity = savedEntity
                .map(userOfferEntity ->
                        domainUserOfferMapper.toEntity(userOfferEntity, userOfferPayload)
                )
                .map(UserOfferEntity::updateUserOffers);
        return domainEntity.flatMap(domainUserOfferDataService::update);
    }

    @Override
    public Mono<Set<String>> getUserOffers(String userId) {
        return getOrCreate(userId)
                .map(UserOfferEntity::getUserOffersId);
    }

    private Mono<UserOfferEntity> getOrCreate(String userId) {
        return domainUserOfferDataService.get(userId)
                .switchIfEmpty(domainUserOfferDataService.save(
                        UserOfferEntity.userOfferEntityWithId(userId)
                ));
    }
}
