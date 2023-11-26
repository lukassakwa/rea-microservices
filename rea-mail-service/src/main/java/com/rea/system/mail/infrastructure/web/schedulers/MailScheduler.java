package com.rea.system.mail.infrastructure.web.schedulers;

import com.rea.system.mail.domain.DomainMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@RequiredArgsConstructor
public class MailScheduler {

    private final DomainMailService offerMailService;

    @Async
    @Scheduled(cron = "0 0 */2 * * *")
    void sendMail() {
        offerMailService.sendEmailToUser();
    }

}
