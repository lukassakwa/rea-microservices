package com.rea.system.intent.domain.offer;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.LinkedMultiValueMap;
import rea.system.common.model.offer.EstateServiceType;

import java.util.Optional;

@Builder
public class OfferQueryBuilder {

    private EstateServiceType estateServiceType;
    private Boolean force;
    private Integer priceFrom;
    private Integer priceTo;
    private Double metersFrom;
    private Double metersTo;

    @Getter
    private final LinkedMultiValueMap<String, String> query = new LinkedMultiValueMap<>();

    private void initialize() {
        buildQueryParams();
    }

    private void buildQueryParams() {
        Optional.ofNullable(estateServiceType).ifPresent(serviceType -> query.add("estateServiceType", serviceType.name()));
        Optional.ofNullable(force).ifPresent(f -> query.add("force", f.toString()));
        Optional.ofNullable(priceFrom).ifPresent(priceF -> query.add("priceFrom", priceF.toString()));
        Optional.ofNullable(priceTo).ifPresent(priceT -> query.add("priceTo", priceT.toString()));
        Optional.ofNullable(metersFrom).ifPresent(metersF -> query.add("metersFrom", metersF.toString()));
        Optional.ofNullable(metersTo).ifPresent(metersT -> query.add("metersTo", metersT.toString()));
    }

    public static OfferQueryBuilderBuilder builder() {
        return new CustomOfferQueryBuilder();
    }

    private static class CustomOfferQueryBuilder extends OfferQueryBuilderBuilder {

        @Override
        public OfferQueryBuilder build() {
            OfferQueryBuilder offerQueryBuilder = super.build();
            offerQueryBuilder.initialize();
            return offerQueryBuilder;
        }
    }


}
