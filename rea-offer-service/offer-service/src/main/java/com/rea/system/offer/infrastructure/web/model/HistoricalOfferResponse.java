package com.rea.system.offer.infrastructure.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricalOfferResponse {

    private String href;
    private String fullAddress;
    private Integer price;
    private LocalDateTime modifiedAt;

}
