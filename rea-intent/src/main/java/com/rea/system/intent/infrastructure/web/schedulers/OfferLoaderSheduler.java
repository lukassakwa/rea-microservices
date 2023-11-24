package com.rea.system.intent.infrastructure.web.schedulers;

import com.rea.system.intent.domain.offer.OfferIntentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableScheduling
@RequiredArgsConstructor
public class OfferLoaderSheduler {

    private final OfferIntentService offerIntentService;

    @Async
    @Scheduled(cron = "0 0/5 * * * ?")
    public void scheduleOfferLoad() {
        offerIntentService.invokeOfferEngine();
    }

}
