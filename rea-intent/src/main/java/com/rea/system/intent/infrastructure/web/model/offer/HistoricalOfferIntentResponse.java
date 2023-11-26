package com.rea.system.intent.infrastructure.web.model.offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricalOfferIntentResponse {

    private String href;
    private String fullAddress;
    private Integer price;
    private LocalDateTime modifiedAt;

}
