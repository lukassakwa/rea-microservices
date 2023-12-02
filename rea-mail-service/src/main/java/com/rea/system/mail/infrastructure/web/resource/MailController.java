package com.rea.system.mail.infrastructure.web.resource;

import com.rea.system.mail.domain.DomainMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/mail")
@RequiredArgsConstructor
public class MailController {

    private final DomainMailService mailService;

    @GetMapping("/invoke")
    Mono<Void> invokeEngine() {
        mailService.sendEmailToUser();
        return Mono.empty();
    }

}
