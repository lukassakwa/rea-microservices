package com.rea.system.intent.infrastructure.web.model.user;

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
