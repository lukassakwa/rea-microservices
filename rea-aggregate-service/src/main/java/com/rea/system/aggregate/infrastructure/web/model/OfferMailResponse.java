package com.rea.system.aggregate.infrastructure.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferMailResponse {

    private String href;
    private Integer price;
    private Double meters;

}
