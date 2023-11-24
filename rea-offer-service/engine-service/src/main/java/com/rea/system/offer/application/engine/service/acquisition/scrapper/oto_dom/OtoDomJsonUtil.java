package com.rea.system.offer.application.engine.service.acquisition.scrapper.oto_dom;

import lombok.experimental.UtilityClass;

@UtilityClass
public class OtoDomJsonUtil {

    private static final String EMPTY_STRING = "";
    private static final String OPEN_BRACKET = "{";
    private static final String CLOSE_BRACKET = "}";

    public static String createJsonFromHtml(String htmlBody, String startElement, String endElement) {
        int startWith = htmlBody.indexOf(startElement);
        int endsWith = htmlBody.indexOf(endElement);
        String offerJson = htmlBody.substring(startWith, endsWith - 1);
        return String.join(EMPTY_STRING, OPEN_BRACKET, offerJson, CLOSE_BRACKET);
    }

}
