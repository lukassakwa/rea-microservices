package com.rea.system.offer.application.domain;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.rea.system.offer.application.domain.entity.Fillter;
import com.rea.system.offer.infrastructure.dataaccess.entity.QOffer;
import lombok.Builder;
import org.assertj.core.util.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Builder
class DomainQueryBuilderImpl implements DomainQueryBuilder<BooleanExpression> {


    private final Fillter fillter;

    @Override
    public BooleanExpression buildQuery() {
        List<BooleanExpression> criteriaList = buildCriteria();
        return Expressions.allOf(criteriaList.toArray(new BooleanExpression[0]));
    }

    private List<BooleanExpression> buildCriteria() {
        List<BooleanExpression> predicates = Lists.newArrayList();
        Optional.ofNullable(this.fillter.getPriceFrom()).ifPresent(priceFrom -> predicates.add(QOffer.offer.price.gt(priceFrom)));
        Optional.ofNullable(this.fillter.getPriceTo()).ifPresent(priceTo -> predicates.add(QOffer.offer.price.lt(priceTo)));
        Optional.ofNullable(this.fillter.getMetersFrom()).ifPresent(metersFrom -> predicates.add(QOffer.offer.meters.gt(metersFrom)));
        Optional.ofNullable(this.fillter.getMetersTo()).ifPresent(metersTo -> predicates.add(QOffer.offer.meters.lt(metersTo)));

        if (!CollectionUtils.isEmpty(this.fillter.getOfferIds())) {
            predicates.add(QOffer.offer.id.in(this.fillter.getOfferIds()));
        }

        return predicates;
    }
}
