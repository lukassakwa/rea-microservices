package com.rea.system.offer.application.engine;

import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.application.engine.model.OfferLoadDto;
import com.rea.system.offer.application.engine.service.AcquisitionReactiveOfferService;
import com.rea.system.offer.application.engine.service.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Service
@RequiredArgsConstructor
class OfferProcessingServiceImpl implements OfferProcessingService {

    private final AcquisitionReactiveOfferService acquisitionReactiveOfferService;
    private final DataService dataService;

    @Override
    public void process(OfferLoadDto offerLoadDto) {
        Flux.fromIterable(offerLoadDto.getOffersUrl())
                .subscribeOn(Schedulers.boundedElastic())
                .map(href -> buildOfferContext(href, offerLoadDto))
                .flatMap(acquisitionReactiveOfferService::resolveAllSpecificOffers)
                .filter(ResolveOffer::isOfferValid)
                .map(ResolveOffer::prepareKeyValues)
                .groupBy(ResolveOffer::getDuplicateKey)
                .flatMap(resolveOffers -> resolveOffers.reduce(ResolveOffer::order))
                .subscribe(dataService::upsertOfferAndMoveToHistoricalIfNecessarily);
    }

    private OfferLoadContext buildOfferContext(String url, OfferLoadDto offerLoadDto) {
        return OfferLoadContext.builder()
                .url(url)
                .estateServiceType(offerLoadDto.getEstateServiceType())
                .build();
    }

}
