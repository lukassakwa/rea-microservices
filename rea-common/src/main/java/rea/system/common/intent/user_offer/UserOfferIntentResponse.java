package rea.system.common.intent.user_offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOfferIntentResponse {

    private Set<String> userOffersId;

}
