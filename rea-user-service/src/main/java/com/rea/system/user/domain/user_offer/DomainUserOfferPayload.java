package com.rea.system.user.domain.user_offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rea.system.common.model.user_offer.FavoriteOperationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DomainUserOfferPayload {

    private String userId;
    private String offerId;
    private FavoriteOperationType operationType;

}
