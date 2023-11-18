package rea.system.common.dto.offer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.assertj.core.util.Lists;
import rea.system.common.model.offer.Floor;
import rea.system.common.model.offer.Room;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferDto {

    private String id;
    private String publicId;
    @Builder.Default
    private List<String> images = Lists.newArrayList();
    private String href;
    private String title;
    private String description;
    private String fullAddress;
    private Integer price;
    private Double meters;
    private Room roomNumber;
    private Floor floor;
    private LocalDateTime modifiedAt;
    private LocalDateTime createdAt;

}
