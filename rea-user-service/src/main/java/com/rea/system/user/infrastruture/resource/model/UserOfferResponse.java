package com.rea.system.user.infrastruture.resource.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOfferResponse {

    private Set<String> userOffersId;

}
