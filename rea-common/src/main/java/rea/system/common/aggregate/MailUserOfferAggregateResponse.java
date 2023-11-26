package rea.system.common.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailUserOfferAggregateResponse {

    private String username;
    private List<OfferMailResponse> offersEntity;

}
