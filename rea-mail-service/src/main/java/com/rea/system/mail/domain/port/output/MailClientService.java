package com.rea.system.mail.domain.port.output;

public interface MailClientService {

    void sendMail(String to, String subject, String text, boolean isHtmlContent);

}
