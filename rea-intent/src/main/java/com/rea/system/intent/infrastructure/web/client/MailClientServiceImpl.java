package com.rea.system.intent.infrastructure.web.client;

import com.rea.system.intent.domain.port.output.client.MailClientService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MailClientServiceImpl implements MailClientService {

    private final WebClient mailWebClient;

    public MailClientServiceImpl(@Qualifier("mailClient") WebClient mailWebClient) {
        this.mailWebClient = mailWebClient;
    }
    @Override
    public void invokeSendMail() {
        mailWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/mail/invoke")
                        .build())
                .retrieve()
                .bodyToMono(Void.class)
                .subscribe();
    }
}
