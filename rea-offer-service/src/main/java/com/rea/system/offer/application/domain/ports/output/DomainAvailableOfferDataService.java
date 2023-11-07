package com.rea.system.offer.application.domain.ports.output;

import com.rea.system.offer.application.domain.entity.DomainOffer;
import com.rea.system.offer.application.domain.entity.Fillter;
import org.springframework.data.domain.Page;
import rea.system.common.model.EstateServiceType;

import java.util.List;

public interface DomainAvailableOfferDataService {

    List<DomainOffer> findOffersById(Fillter fillter, int pageIndex, int pageSize);

    DomainOffer findById(String offerId, EstateServiceType estateServiceType);

}