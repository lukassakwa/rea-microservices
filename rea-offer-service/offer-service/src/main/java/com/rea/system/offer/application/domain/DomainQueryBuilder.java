package com.rea.system.offer.application.domain;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.rea.system.offer.application.domain.core.DomainOffer;
import com.rea.system.offer.application.domain.core.Fillter;
import com.rea.system.offer.infrastructure.dataaccess.entity.QOffer;
import lombok.Builder;
import lombok.Getter;
import org.assertj.core.util.Lists;
import org.springframework.data.domain.Sort;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Builder
class DomainQueryBuilder {

    private final Fillter fillter;

    @Getter
    private BooleanExpression expression;
    @Getter
    private Sort sort;

    public void buildQuery() {
        List<BooleanExpression> criteriaList = buildCriteria();
        expression = Expressions.allOf(criteriaList.toArray(new BooleanExpression[0]));
        sort = Sort.by(Sort.Order.desc(DomainOffer.MODIFIED_DATE), Sort.Order.asc(DomainOffer.ID));
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
