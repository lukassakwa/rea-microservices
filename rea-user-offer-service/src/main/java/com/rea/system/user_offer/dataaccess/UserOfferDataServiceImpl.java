package com.rea.system.user_offer.dataaccess;

import com.rea.system.user_offer.domain.core.UserOfferEntity;
import com.rea.system.user_offer.domain.port.output.DomainUserOfferDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserOfferDataServiceImpl implements DomainUserOfferDataService {

    private final UserOfferRepository userOfferRepository;
    private final UserOfferMapper userOfferMapper;

    @Override
    public Mono<UserOfferEntity> save(UserOfferEntity userOfferEntity) {
        return userOfferRepository.save(userOfferMapper.toModel(userOfferEntity))
                .map(userOfferMapper::toEntity);
    }

    @Override
    public Mono<UserOfferEntity> get(String userId) {
        return userOfferRepository.findUserOfferByUserId(userId)
                .map(userOfferMapper::toEntity);
    }
}
