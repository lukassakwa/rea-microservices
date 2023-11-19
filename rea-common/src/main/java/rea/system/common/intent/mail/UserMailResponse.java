package rea.system.common.intent.mail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rea.system.common.model.offer.EstateServiceType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMailResponse {

    private String username;
    private EstateServiceType service;
    private Integer priceFrom;
    private Integer priceTo;
    private Double metersFrom;
    private Double metersTo;

}
