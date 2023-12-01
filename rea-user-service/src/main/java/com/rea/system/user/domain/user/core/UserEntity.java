package com.rea.system.user.domain.user.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    private String userId;
    private String username;
    @Builder.Default
    private UserFilterSettingsEntity userFilterSettingsEntity = UserFilterSettingsEntity.builder().build();

    public static UserEntity userEntityWithUserId(String userId) {
        return UserEntity.builder()
                .userId(userId)
                .build();
    }

}
