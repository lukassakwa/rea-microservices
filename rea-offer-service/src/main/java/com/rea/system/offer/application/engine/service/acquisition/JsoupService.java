package com.rea.system.offer.application.engine.service.acquisition;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class JsoupService {

    @SneakyThrows
    public Document initJsoup(String url) {
        return Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:108.0) Gecko/20100101 Firefox/108.0")
                .timeout(40_000)
                .get();
    }

}
