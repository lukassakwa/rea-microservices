package com.rea.system.user.infrastruture.dataaccess.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document("user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;
    @Indexed
    private String userId;
    private String username;
    private UserFilterSettings userFilterSettings;
    private Set<String> userOffersId;

}
