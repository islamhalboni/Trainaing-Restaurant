package com.example.Restaurant.Authentication;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("user")
public class Auth {
    @Id
    private String id;
    private String username;
    private String password;
    private boolean isActive;
}
