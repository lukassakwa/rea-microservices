package com.rea.system.offer.application.domain.ports.output;

import com.rea.system.offer.application.domain.entity.DomainOffer;
import com.rea.system.offer.application.domain.entity.Fillter;
import org.springframework.data.domain.Page;
import rea.system.common.model.EstateServiceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface DomainAvailableOfferDataService {

    Flux<DomainOffer> findOffersById(Fillter fillter, int pageIndex, int pageSize);

    Mono<DomainOffer> findById(String offerId, EstateServiceType estateServiceType);

}