package com.rea.system.intent.infrastructure.web.schedulers;

import com.rea.system.intent.domain.mail.MailIntentService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@RequiredArgsConstructor
public class MailScheduler {

    private final MailIntentService mailIntentService;

    @Async
    @Scheduled(cron = "0 0/30 * * * ?")
    void sendMail() {
        mailIntentService.invokeMailSend();
    }

}
