package com.rea.system.aggregate.domain.user_offer.core;

import lombok.Builder;
import lombok.Data;
import org.springframework.util.LinkedMultiValueMap;
import rea.system.common.model.offer.EstateServiceType;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@Data
@Builder
public class OfferAggregateQuery {

    private EstateServiceType estateServiceType;
    private Set<String> offerIds;

    public LinkedMultiValueMap<String, String> buildQueryParams() {
        final LinkedMultiValueMap<String, String> queryMap = new LinkedMultiValueMap<>();
        Optional.ofNullable(estateServiceType).ifPresent(serviceType -> queryMap.add("estateServiceType", serviceType.name()));
        Optional.ofNullable(offerIds).ifPresent(offers -> queryMap.put("offerIds", new ArrayList<>(offers)));
        return queryMap;
    }

}
