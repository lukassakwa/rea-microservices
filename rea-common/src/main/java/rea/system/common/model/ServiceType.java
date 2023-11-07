package rea.system.common.model;

import java.util.Arrays;

public enum ServiceType {
    OTO_DOM("otodom.pl", 0),
    OLX("olx.pl", 1),
    GRATKA("gratka.pl", 2),
    MORIZON("morizon.pl", 3);

    private String url;
    private Integer index;

    ServiceType(String url, Integer index) {
        this.url = url;
        this.index = index;
    }

    public String getUrl() {
        return url;
    }

    public Integer getIndex() {
        return index;
    }

    public static ServiceType getServiceType(String href) {
        return Arrays.stream(ServiceType.values())
                .filter(serviceType -> href.contains(serviceType.getUrl()))
                .findAny()
                .orElseThrow(IllegalAccessError::new);
    }
}
