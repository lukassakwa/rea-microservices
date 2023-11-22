package com.rea.system.offer.application.engine.service.acquisition.scrapper.common;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.math.RoundingMode;

@UtilityClass
public class MapperUtils {

    public static String parseGeo(String value) {
        if (value == null) {
            return "0";
        }
        BigDecimal val = new BigDecimal(value).setScale(4, RoundingMode.HALF_EVEN);
        return String.valueOf(val);
    }

    public static String removeHtmlTags(String text) {
        return text.replaceAll("<[^>]*>", "");
    }

}
