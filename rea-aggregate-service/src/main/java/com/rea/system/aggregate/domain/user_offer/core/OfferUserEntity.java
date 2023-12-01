package com.rea.system.aggregate.domain.user_offer.core;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Set;

@Data
public class OfferUserEntity {

    private Set<String> userOffersId;

    public OfferUserEntity validate() {
        if (CollectionUtils.isEmpty(userOffersId)) {
            throw new RuntimeException("user offers are empty");
        }
        return this;
    }

}
