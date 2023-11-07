package com.rea.system.app.service;

import com.rea.system.app.client.OfferClient;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import rea.system.common.dto.OfferDto;
import rea.system.common.model.EstateServiceType;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferClient offerClient;

    public Page<OfferDto> getPaginatedOffers(EstateServiceType estateServiceType,
                                             String pageIndex,
                                             String pageSize,
                                             Integer priceFrom,
                                             Integer priceTo,
                                             Double metersFrom,
                                             Double metersTo) {
        List<OfferDto> offers = offerClient.getOffers(estateServiceType, pageIndex, pageSize,
                priceFrom, priceTo, metersFrom, metersTo);
        return new PageImpl<>(
                offers,
                PageRequest.of(Integer.parseInt(pageIndex), Integer.parseInt(pageSize)),
                offers.size());
    }
}
