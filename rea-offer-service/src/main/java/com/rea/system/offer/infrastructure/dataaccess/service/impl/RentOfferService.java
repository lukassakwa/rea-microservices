package com.rea.system.offer.infrastructure.dataaccess.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.rea.system.offer.application.domain.entity.DomainOffer;
import com.rea.system.offer.application.domain.entity.Fillter;
import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.RentOffer;
import com.rea.system.offer.infrastructure.dataaccess.mapper.OfferMapper;
import com.rea.system.offer.infrastructure.dataaccess.repository.RentOfferRepository;
import com.rea.system.offer.infrastructure.dataaccess.service.AvailableDomainOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.AvailableEngineOfferService;
import com.rea.system.offer.infrastructure.dataaccess.service.impl.query_builder.OfferPredicateBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static com.rea.system.offer.infrastructure.dataaccess.entity.Offer.ID;
import static com.rea.system.offer.infrastructure.dataaccess.entity.Offer.MODIFIED_DATE;

@Service
@RequiredArgsConstructor
public class RentOfferService implements AvailableEngineOfferService, AvailableDomainOfferService {

    private final RentOfferRepository rentOfferRepository;
    private final OfferMapper offerMapper;

    @Override
    public Mono<ResolveOffer> save(ResolveOffer resolveOffer) {
        Mono<RentOffer> savedOffer = rentOfferRepository.save(offerMapper.toRentEntity(resolveOffer));
        return savedOffer.map(offerMapper::toResolveRentDto);
    }

    @Override
    public Mono<ResolveOffer> update(String offerId, ResolveOffer updatedOffer) {
        return findResolveOfferById(offerId)
                .map(foundOffer -> offerMapper.updateOffer(foundOffer, updatedOffer))
                .flatMap(this::save);
    }

    @Override
    public Mono<ResolveOffer> findByDuplicateKey(String dupicateKey) {
        return rentOfferRepository.findByDuplicateKey(dupicateKey)
                .map(offerMapper::toResolveRentDto);
    }

    @Override
    public Flux<DomainOffer> findOffersById(Fillter filterDto, int pageIndex, int pageSize) {
        BooleanExpression expression = OfferPredicateBuilder.builder()
                .fillter(filterDto)
                .build()
                .buildQuery();
        Sort sort = Sort.by(Sort.Order.desc(MODIFIED_DATE), Sort.Order.asc(ID));
        Pageable pageable = PageRequest.of(pageIndex, pageSize, sort);
        return Optional.ofNullable(expression)
                .map(expr -> rentOfferRepository.findAllBy(expr, pageable))
                .orElse(rentOfferRepository.findAllBy(pageable))
                .map(offerMapper::toDomainRentDto);
    }

    @Override
    public Mono<DomainOffer> findById(String offerId) {
        Mono<RentOffer> offer = rentOfferRepository.findById(offerId)
                .switchIfEmpty(Mono.error(new IllegalStateException("Offer does not exist")));
        return offer.map(offerMapper::toDomainRentDto);
    }

    private Mono<ResolveOffer> findResolveOfferById(String offerId) {
        Mono<RentOffer> offer = rentOfferRepository.findById(offerId)
                .switchIfEmpty(Mono.error(new IllegalStateException("Offer does not exist")));
        return offer.map(offerMapper::toResolveRentDto);
    }

}
