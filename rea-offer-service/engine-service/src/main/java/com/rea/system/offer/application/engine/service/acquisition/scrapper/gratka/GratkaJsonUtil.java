package com.rea.system.offer.application.engine.service.acquisition.scrapper.gratka;

import lombok.experimental.UtilityClass;

@UtilityClass
public class GratkaJsonUtil {
    private static final String OPEN_ROUND_BRACKET = "(";
    private static final String CLOSE_ROUND_BRACKET = ")";
    private final String START_TEXT = "const addressObject =";
    private final String END_TEXT = "const addressHTML";

    public static String createJsonFromHtml(String body) {
        int startIndex = body.indexOf(OPEN_ROUND_BRACKET) + 1;
        int endIndex = body.indexOf(CLOSE_ROUND_BRACKET);
        return body.substring(startIndex, endIndex);
    }

    public static String createLocalizationJsonFromHtml(String localizationJson) {
        int start = localizationJson.indexOf(START_TEXT);
        int end = localizationJson.indexOf(END_TEXT);
        return localizationJson.substring(start + START_TEXT.length(), end-1);
    }

}
