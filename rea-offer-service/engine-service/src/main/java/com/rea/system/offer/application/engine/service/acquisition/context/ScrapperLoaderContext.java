package com.rea.system.offer.application.engine.service.acquisition.context;

import com.rea.system.offer.application.engine.OfferLoadContext;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.jsoup.nodes.Document;

@Builder
@Getter
@Setter
public class ScrapperLoaderContext {
    private GeneralOfferContext generalOfferContext;
    private Document document;
    private OfferLoadContext offerLoadContext;

    public static ScrapperLoaderContext buildContext(GeneralOfferContext generalOfferContext,
                                                     Document document,
                                                     OfferLoadContext offerLoadContext) {
        return ScrapperLoaderContext.builder()
                .document(document)
                .generalOfferContext(generalOfferContext)
                .offerLoadContext(offerLoadContext)
                .build();
    }

}