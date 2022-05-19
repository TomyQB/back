package com.appuntate.back.security.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtDTO {

    private String token;
    private String bearer = "Bearer";

    private long userId;
    private String userName;
    private String name;
    private String surnames;
    private String photo;
    private String email;
    private String phoneNumber;
    private String password;
    private List<String> rols;


    public JwtDTO(String token, long userId, String userName, String name, String surnames, String photo, String email,
            String phoneNumber, String password) {
        this.token = token;
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.surnames = surnames;
        this.photo = photo;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    
}
