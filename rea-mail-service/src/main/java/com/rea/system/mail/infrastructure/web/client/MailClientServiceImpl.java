package com.rea.system.mail.infrastructure.web.client;

import com.rea.system.mail.domain.port.output.MailClientService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
@RequiredArgsConstructor
class MailClientServiceImpl implements MailClientService {

    private final JavaMailSender javaMailSender;

    @SneakyThrows
    public void sendMail(String to, String subject, String text, boolean isHtmlContent) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text, isHtmlContent);
        javaMailSender.send(mimeMessage);
    }


}
