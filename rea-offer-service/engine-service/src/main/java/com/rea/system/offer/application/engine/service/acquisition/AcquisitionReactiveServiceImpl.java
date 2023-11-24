package com.rea.system.offer.application.engine.service.acquisition;

import com.rea.system.offer.application.engine.OfferLoadContext;
import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.application.engine.service.AcquisitionReactiveOfferService;
import com.rea.system.offer.application.engine.service.acquisition.context.GeneralOfferContext;
import com.rea.system.offer.application.engine.service.acquisition.context.ScrapperLoaderContext;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.OfferScrapperService;
import com.rea.system.offer.application.engine.service.acquisition.scrapper.OfferScrapperServiceFactory;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import rea.system.common.model.offer.ServiceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Service
@RequiredArgsConstructor
public class AcquisitionReactiveServiceImpl implements AcquisitionReactiveOfferService {

    private final OfferScrapperServiceFactory offerScrapperServiceFactory;
    private final WebClient webClient;

    @Override
    @SneakyThrows
    public Flux<ResolveOffer> resolveAllSpecificOffers(OfferLoadContext context) {
        OfferScrapperService<? extends GeneralOfferContext> service = getService(context.getUrl());
        return getDocument(context.getUrl())
                .map(service::generalOffersInfo)
                .flatMapMany(Flux::fromIterable)
                .filter(GeneralOfferContext::filterOffers)
                .flatMap(generalOfferContext -> scrapDetailsOffer(generalOfferContext, context))
                .onErrorResume(e -> Mono.empty());
    }

    private Mono<Document> getDocument(String url) {
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .map(Jsoup::parse)
                .onErrorStop()
                .subscribeOn(Schedulers.boundedElastic());
    }

    private Mono<ResolveOffer> scrapDetailsOffer(GeneralOfferContext generalOfferContext, OfferLoadContext offerLoadContext) {
        Mono<Document> document = getDocument(generalOfferContext.getDetailsUrl());
        Mono<ScrapperLoaderContext> scrapperLoaderContextMono = document.map(receivedDocument ->
                ScrapperLoaderContext.buildContext(generalOfferContext, receivedDocument, offerLoadContext)
        );
        return scrapperLoaderContextMono.map(this::scrapSpecificOffer);
    }

    private ResolveOffer scrapSpecificOffer(ScrapperLoaderContext scrapperLoaderContext) {
        String url = scrapperLoaderContext.getGeneralOfferContext().getDetailsUrl();
        OfferScrapperService<GeneralOfferContext> offerScrapperService = (OfferScrapperService<GeneralOfferContext>) getService(url);
        return offerScrapperService.specificOffer(
                scrapperLoaderContext.getGeneralOfferContext(),
                scrapperLoaderContext.getDocument(),
                scrapperLoaderContext.getOfferLoadContext());
    }

    private OfferScrapperService<? extends GeneralOfferContext> getService(String url) {
        ServiceType type = ServiceType.getServiceType(url);
        return offerScrapperServiceFactory.findStrategy(type);
    }

}
