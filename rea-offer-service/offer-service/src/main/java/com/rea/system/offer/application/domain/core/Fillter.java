package com.rea.system.offer.application.domain.core;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.rea.system.offer.infrastructure.dataaccess.entity.QOffer;
import lombok.Builder;
import lombok.Getter;
import org.assertj.core.util.Lists;
import org.springframework.data.domain.Sort;
import org.springframework.util.CollectionUtils;
import rea.system.common.model.offer.EstateServiceType;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Getter
@Builder
public class Fillter {

    private EstateServiceType service;
    private Integer priceFrom;
    private Integer priceTo;
    private Double metersFrom;
    private Double metersTo;
    private Set<String> offerIds;

    @Getter
    private BooleanExpression expression;
    @Getter
    private Sort sort;

    private void initialize() {
        buildQuery();
        validateExpression();
    }

    private void buildQuery() {
        List<BooleanExpression> criteriaList = buildCriteria();
        expression = Expressions.allOf(criteriaList.toArray(new BooleanExpression[0]));
        sort = Sort.by(Sort.Order.desc(DomainOffer.MODIFIED_DATE), Sort.Order.asc(DomainOffer.ID));
    }

    private List<BooleanExpression> buildCriteria() {
        List<BooleanExpression> predicates = Lists.newArrayList();
        Optional.ofNullable(this.priceFrom).ifPresent(priceFrom -> predicates.add(QOffer.offer.price.gt(priceFrom)));
        Optional.ofNullable(this.priceTo).ifPresent(priceTo -> predicates.add(QOffer.offer.price.lt(priceTo)));
        Optional.ofNullable(this.metersFrom).ifPresent(metersFrom -> predicates.add(QOffer.offer.meters.gt(metersFrom)));
        Optional.ofNullable(this.metersTo).ifPresent(metersTo -> predicates.add(QOffer.offer.meters.lt(metersTo)));

        if (!CollectionUtils.isEmpty(this.offerIds)) {
            predicates.add(QOffer.offer.id.in(this.offerIds));
        }

        return predicates;
    }

    private void validateExpression() {
        Optional.ofNullable(expression).orElseThrow(() -> new RuntimeException("Expression is null"));
    }

    public static FillterBuilder builder() {
        return new CustomFillterBuilder();
    }

    private static class CustomFillterBuilder extends FillterBuilder {

        @Override
        public Fillter build() {
            Fillter fillter = super.build();
            fillter.initialize();
            return fillter;
        }
    }

}
