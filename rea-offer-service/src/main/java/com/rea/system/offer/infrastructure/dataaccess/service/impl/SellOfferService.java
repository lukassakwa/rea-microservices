package com.rea.system.offer.infrastructure.dataaccess.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.rea.system.offer.application.domain.entity.DomainOffer;
import com.rea.system.offer.application.domain.entity.Fillter;
import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.infrastructure.dataaccess.entity.SellOffer;
import com.rea.system.offer.infrastructure.dataaccess.mapper.OfferMapper;
import com.rea.system.offer.infrastructure.dataaccess.repository.SellOfferRepository;
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
public class SellOfferService implements AvailableEngineOfferService, AvailableDomainOfferService {

    private final SellOfferRepository sellOfferRepository;
    private final OfferMapper offerMapper;

    @Override
    public Optional<ResolveOffer> findByDuplicateKey(String dupicateKey) {
        return sellOfferRepository.findByDuplicateKey(dupicateKey).map(offerMapper::toResolveSellDto);
    }

    @Override
    public ResolveOffer save(ResolveOffer offerDto) {
        SellOffer offer = sellOfferRepository.save(offerMapper.toSellEntity(offerDto));
        return offerMapper.toResolveSellDto(offer);
    }

    @Override
    public ResolveOffer update(String offerId, ResolveOffer updatedOffer) {
        ResolveOffer offer = findResolveOfferById(offerId);
        ResolveOffer updatedOfferDto = offerMapper.updateOffer(offer, updatedOffer);
        return save(updatedOfferDto);
    }

    @Override
    public List<DomainOffer> findOffersById(Fillter fillter, int pageIndex, int pageSize) {
        BooleanExpression expression = OfferPredicateBuilder.builder()
                .fillter(fillter)
                .build()
                .buildQuery();
        Sort sort = Sort.by(Sort.Order.desc(MODIFIED_DATE), Sort.Order.asc(ID));
        Pageable pageable = PageRequest.of(pageIndex, pageSize, sort);
        return Optional.ofNullable(expression).map(expr -> sellOfferRepository.findAll(expr, pageable))
                .orElse(sellOfferRepository.findAll(pageable))
                .getContent().stream()
                .map(offerMapper::toDomainSellDto)
                .toList();
    }

    @Override
    public DomainOffer findById(String offerId) {
        SellOffer offer = sellOfferRepository.findById(offerId).orElseThrow();
        return offerMapper.toDomainSellDto(offer);
    }

    private ResolveOffer findResolveOfferById(String offerId) {
        SellOffer offer = sellOfferRepository.findById(offerId).orElseThrow();
        return offerMapper.toResolveSellDto(offer);
    }

}
