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
import rea.system.common.model.ServiceType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

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
        return getMainDocument(context.getUrl())
                .map(service::generalOffersInfo)
                .flatMapMany(Flux::fromIterable)
                .filter(GeneralOfferContext::filterOffers)
                .flatMap(this::getContextWithDocument)
                .map(scrappedContext -> this.scrappedDetailsOffer(scrappedContext, context))
                .onErrorResume(e ->  {
                    log.warn("warn: {}", e.getMessage());
                    return Mono.empty();
                });
    }

    private Mono<ScrapperLoaderContext> getContextWithDocument(GeneralOfferContext context) {
        return webClient.get()
                .uri(context.getDetailsUrl())
                .retrieve()
                .bodyToMono(String.class)
                .map(body -> ScrapperLoaderContext.builder()
                        .document(Jsoup.parse(body))
                        .generalOfferContext(context)
                        .build()
                );
    }

    private Mono<Document> getMainDocument(String url) {
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .map(Jsoup::parse);
    }

    private ResolveOffer scrappedDetailsOffer(ScrapperLoaderContext scrapperLoaderContext, OfferLoadContext offerLoadContext) {
        String url = scrapperLoaderContext.getGeneralOfferContext().getDetailsUrl();
        OfferScrapperService<GeneralOfferContext> offerScrapperService = (OfferScrapperService<GeneralOfferContext>) getService(url);
        return offerScrapperService.specificOffer(
                scrapperLoaderContext.getGeneralOfferContext(),
                scrapperLoaderContext.getDocument(),
                offerLoadContext);
    }

    private OfferScrapperService<? extends GeneralOfferContext> getService(String url) {
        ServiceType type = ServiceType.getServiceType(url);
        return offerScrapperServiceFactory.findStrategy(type);
    }

}
