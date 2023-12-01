package com.rea.system.aggregate.domain.user_offer.core;

import lombok.Builder;
import lombok.Data;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import rea.system.common.model.offer.EstateServiceType;

import java.util.*;
import java.util.stream.Stream;

@Data
@Builder
public class OfferAggregateQuery {

    private EstateServiceType estateServiceType;
    private Set<String> offerIds;

    private final LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();

    private void init() {
        validate();
        buildQueryParams();
    }

    public void buildQueryParams() {
        Optional.ofNullable(estateServiceType).ifPresent(serviceType -> query.add("estateServiceType", serviceType.name()));
        Optional.ofNullable(offerIds).ifPresent(offers -> query.put("userOfferIds", new ArrayList<>(offers)));
    }

    private void validate() {
        if (Objects.isNull(estateServiceType) || CollectionUtils.isEmpty(offerIds)) {
            throw new RuntimeException("values are null");
        }
    }

    public static OfferAggregateQueryBuilder builder() {
        return new CustomOfferAggregateQueryBuilder();
    }

    private static class CustomOfferAggregateQueryBuilder extends OfferAggregateQueryBuilder {

        @Override
        public OfferAggregateQuery build() {
            OfferAggregateQuery offerAggregateQuery = super.build();
            offerAggregateQuery.init();
            return offerAggregateQuery;
        }
    }

}
