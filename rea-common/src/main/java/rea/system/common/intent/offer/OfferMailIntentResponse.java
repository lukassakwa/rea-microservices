package rea.system.common.intent.offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferMailIntentResponse {

    private String href;
    private String title;
    private String fullAddress;
    private Integer price;

}
