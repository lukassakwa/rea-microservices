package rea.system.common.mail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferMailResponse {

    private String href;
    private String fullAddress;
    private Integer price;
    private Double meters;

}
