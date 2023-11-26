package com.rea.system.mail.domain.core;

import lombok.Data;

@Data
public class OfferMailEntity {

    private String href;
    private Integer price;
    private Double meters;

    private static final String CONTENT = "<p>Cena: %d, meters: %,.2f, Link: <a href=\"%s\"> %s </a></p>";

    String getHtmlContent() {
        return String.format(CONTENT, price, meters, href, href);
    }

}
