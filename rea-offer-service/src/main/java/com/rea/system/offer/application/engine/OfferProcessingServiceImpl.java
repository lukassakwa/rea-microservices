package com.rea.system.offer.application.engine;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.application.engine.model.OfferLoadDto;
import com.rea.system.offer.application.engine.service.AcquisitionReactiveOfferService;
import com.rea.system.offer.application.engine.service.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.LinkedHashSet;

import static com.rea.system.offer.application.engine.OfferLoadContext.buildOfferContext;

@Slf4j
@Service
@RequiredArgsConstructor
class OfferProcessingServiceImpl implements OfferProcessingService {

    private final AcquisitionReactiveOfferService acquisitionReactiveOfferService;
    private final DataService dataService;

    @Override
    public void process(OfferLoadDto offerLoadDto) {
        log.info("processing started");
        Flux.fromIterable(offerLoadDto.getOffersUrl())
                .map(href -> buildOfferContext(href, offerLoadDto))
                .flatMap(acquisitionReactiveOfferService::resolveAllSpecificOffers)
                .filter(ResolveOffer::isOfferValid)
                .map(ResolveOffer::prepareKeyValues)
                .sort(Comparator.comparing(ResolveOffer::order))
                .collectList()
                .map(LinkedHashSet::new)
                .flatMapMany(Flux::fromIterable)
                .flatMap(dataService::upsertOfferAndMoveToHistoricalIfNecessarily)
                .collectList()
                .subscribe(resolveOffers -> log.info("processing ended for {} offers", resolveOffers.size()));
    }

}
