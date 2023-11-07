package com.rea.system.offer.application.engine.service.acquisition.scrapper;

import com.rea.system.offer.application.engine.OfferLoadContext;
import com.rea.system.offer.application.engine.entity.ResolveOffer;
import com.rea.system.offer.application.engine.service.acquisition.context.GeneralOfferContext;
import org.jsoup.nodes.Document;
import rea.system.common.model.ServiceType;

import java.util.List;

public interface OfferScrapperService<T extends GeneralOfferContext> {

    List<T> generalOffersInfo(Document document);

    ResolveOffer specificOffer(
            T context,
            Document document,
            OfferLoadContext offerLoadContext
    );

    ServiceType getServiceName();

}
