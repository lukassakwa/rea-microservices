package com.rea.system.offer.application.engine.service.acquisition.scrapper;

import com.rea.system.offer.application.engine.service.acquisition.context.GeneralOfferContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rea.system.common.model.ServiceType;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class OfferScrapperServiceFactory {

    private Map<ServiceType, OfferScrapperService<? extends GeneralOfferContext>> strategies;

    @Autowired
    public OfferScrapperServiceFactory(Set<OfferScrapperService<? extends GeneralOfferContext>> loaderSets) {
        createStrategy(loaderSets);
    }

    public OfferScrapperService<? extends GeneralOfferContext> findStrategy(ServiceType serviceType) {
        return strategies.get(serviceType);
    }

    private void createStrategy(Set<OfferScrapperService<? extends GeneralOfferContext>> strategySet) {
        strategies = new HashMap<>();
        strategySet.forEach(strategy -> strategies.put(strategy.getServiceName(), strategy));
    }

}
