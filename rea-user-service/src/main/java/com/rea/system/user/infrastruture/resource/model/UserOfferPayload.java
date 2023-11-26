package com.rea.system.user.infrastruture.resource.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rea.system.common.model.user_offer.FavoriteOperationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOfferPayload {

    private String userId;
    private String offerId;
    private FavoriteOperationType operationType;

}
