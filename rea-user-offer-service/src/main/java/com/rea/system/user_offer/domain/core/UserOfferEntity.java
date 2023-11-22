package com.rea.system.user_offer.domain.core;

import io.netty.util.internal.ObjectUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.util.CollectionUtils;
import rea.system.common.model.user_offer.FavoriteOperationType;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOfferEntity {

    private String id;
    private String userId;
    private String offerId;
    private FavoriteOperationType operationType;
    private Set<String> userOffersId;

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

}
