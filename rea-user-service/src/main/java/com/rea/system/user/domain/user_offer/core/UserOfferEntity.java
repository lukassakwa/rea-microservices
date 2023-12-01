package com.rea.system.user.domain.user_offer.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.assertj.core.util.Sets;
import org.springframework.util.CollectionUtils;
import rea.system.common.model.user_offer.FavoriteOperationType;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserOfferEntity {

    private String userId;
    private String offerId;
    private FavoriteOperationType operationType;
    @Builder.Default
    private Set<String> userOffersId = Sets.newHashSet();

    public UserOfferEntity updateUserOffers() {
        validateKeyValues();
        updateUserSetOfOffers();
        return this;
    }

    private void updateUserSetOfOffers() {
        initOfferIdsIfEmpty();
        switch (operationType) {
            case ADD -> userOffersId.add(offerId);
            case REMOVE -> userOffersId.remove(offerId);
            default -> throw new RuntimeException("Operation not supported");
        }
    }

    private void validateKeyValues() {
        if (ObjectUtils.anyNull(userId, offerId, operationType)) {
            throw new RuntimeException("key values are not initialize");
        }
    }

    private void initOfferIdsIfEmpty() {
        if (CollectionUtils.isEmpty(userOffersId)) {
            userOffersId = new HashSet<>();
        }
    }

    public static UserOfferEntity userOfferEntityWithId(String userId) {
        return UserOfferEntity.builder()
                .userId(userId)
                .build();
    }

}
