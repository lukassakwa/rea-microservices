package com.rea.system.intent.domain.mail;

import com.rea.system.intent.domain.port.output.client.MailClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailIntentService {

    private final MailClientService mailClientService;

    public void invokeMailSend() {
        mailClientService.invokeSendMail();
    }
}
