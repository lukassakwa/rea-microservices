package rea.system.common.dto.favorites;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteUserDto {

    private String id;
    private String firstName;
    private String lastName;
    private String email;

}
