package com.rea.system.offer.application.domain.ports.output;

import com.rea.system.offer.application.domain.entity.DomainOffer;
import rea.system.common.model.EstateServiceType;

import java.util.List;

public interface DomainHistoricalOfferDataService {

    List<DomainOffer> findByPublicId(String publicId, EstateServiceType estateServiceType);

}
