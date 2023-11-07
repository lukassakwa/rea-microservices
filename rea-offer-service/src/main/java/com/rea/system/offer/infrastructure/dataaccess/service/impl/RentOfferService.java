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

import java.util.List;
import java.util.Optional;

import static com.rea.system.offer.infrastructure.dataaccess.entity.Offer.ID;
import static com.rea.system.offer.infrastructure.dataaccess.entity.Offer.MODIFIED_DATE;

@Service
@RequiredArgsConstructor
public class RentOfferService implements AvailableEngineOfferService, AvailableDomainOfferService {

    private final RentOfferRepository rentOfferRepository;
    private final OfferMapper offerMapper;

    @Override
    public ResolveOffer save(ResolveOffer resolveOffer) {
        RentOffer savedOffer = rentOfferRepository.save(offerMapper.toRentEntity(resolveOffer));
        return offerMapper.toResolveRentDto(savedOffer);
    }

    @Override
    public ResolveOffer update(String offerId, ResolveOffer updatedOffer) {
        ResolveOffer offer = findResolveOfferById(offerId);
        ResolveOffer updatedOfferDto = offerMapper.updateOffer(offer, updatedOffer);
        return save(updatedOfferDto);
    }

    @Override
    public Optional<ResolveOffer> findByDuplicateKey(String dupicateKey) {
        return rentOfferRepository.findByDuplicateKey(dupicateKey).map(offerMapper::toResolveRentDto);
    }

    @Override
    public List<DomainOffer> findOffersById(Fillter filterDto, int pageIndex, int pageSize) {
        BooleanExpression expression = OfferPredicateBuilder.builder()
                .fillter(filterDto)
                .build()
                .buildQuery();
        Sort sort = Sort.by(Sort.Order.desc(MODIFIED_DATE), Sort.Order.asc(ID));
        Pageable pageable = PageRequest.of(pageIndex, pageSize, sort);
        return Optional.ofNullable(expression)
                .map(expr -> rentOfferRepository.findAll(expr, pageable))
                .orElse(rentOfferRepository.findAll(pageable))
                .getContent().stream()
                .map(offerMapper::toDomainRentDto)
                .toList();
    }

    @Override
    public DomainOffer findById(String offerId) {
        RentOffer offer = rentOfferRepository.findById(offerId).orElseThrow();
        return offerMapper.toDomainRentDto(offer);
    }

    private ResolveOffer findResolveOfferById(String offerId) {
        RentOffer offer = rentOfferRepository.findById(offerId).orElseThrow();
        return offerMapper.toResolveRentDto(offer);
    }

}
