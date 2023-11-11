package com.rea.system.offer.infrastructure.web.shedulers;

import com.rea.system.offer.application.engine.ports.input.InvokerEngineService;
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

    private final InvokerEngineService inokerEngineService;

    @Async
    @Scheduled(cron = "0 0/30 * * * ?")
    public void scheduleOfferLoad() {
        inokerEngineService.invoke();
    }

}
