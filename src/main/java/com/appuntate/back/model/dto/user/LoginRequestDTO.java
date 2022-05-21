package com.appuntate.back.model.dto.user;

import lombok.Data;

@Data
public class LoginRequestDTO {

    private String userName;
    private String password;
    
}
