package com.appuntate.back.model.dto;

import lombok.Data;

@Data
public class LoginDTO {

    private String email;
    private String password;
    private boolean isAdmin;
    
}
