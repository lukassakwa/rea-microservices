package com.rea.system.intent.infrastructure.web.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rea.system.common.model.user_offer.FavoriteOperationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOfferIntentPayload {

    private String userId;
    private String offerId;
    private FavoriteOperationType operationType;

}
