package com.rea.system.offer.application.engine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Coordinates {

    private final static String NO_INFORMATION = "no_information";

    private String latitude;
    private String longitude;

    boolean areCoordinatesInValid() {
        return ObjectUtils.anyNull(latitude, longitude);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(getParsedLatitude(), that.getParsedLatitude())
                && Objects.equals(getParsedLongitude(), that.getParsedLongitude());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getParsedLatitude(), getParsedLongitude());
    }

    String getParsedLatitude() {
        return parseGeo(this.latitude);
    }

    String getParsedLongitude() {
        return parseGeo(this.longitude);
    }

    private static String parseGeo(String value) {
        if (value == null) {
            return NO_INFORMATION;
        }
        return new BigDecimal(value).setScale(4, RoundingMode.HALF_UP).toString();
    }
}
