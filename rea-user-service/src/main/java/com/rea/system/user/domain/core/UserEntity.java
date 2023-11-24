package com.rea.system.user.domain.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    private String id;
    private String userId;
    private String username;
    private UserFilterSettingsEntity userFilterSettingsEntity;

    public static UserEntity createDefaultUserSettings(String userId) {
        return UserEntity.builder()
                .userId(userId)
                .build();
    }

}
