package rea.system.common.dto.favorites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rea.system.common.model.offer.EstateServiceType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class FavoriteUserOfferDto {
    String offerId;
    String userId;
    FavoriteOperationType operationType;
    EstateServiceType estateServiceType;
}
