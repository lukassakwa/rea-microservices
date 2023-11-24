package com.rea.system.user_offer.dataaccess;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import rea.system.common.model.user_offer.FavoriteOperationType;

import java.util.Set;

@Data
@Document("user_offer")
@AllArgsConstructor
@NoArgsConstructor
public class UserOffer {

    @Id
    private String id;
    private String userId;
    private Set<String> userOffersId;

}
