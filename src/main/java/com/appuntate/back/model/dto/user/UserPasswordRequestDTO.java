package com.appuntate.back.model.dto.user;

import lombok.Data;

@Data
public class UserPasswordRequestDTO {
    
    private long userId;
    private String oldPassword;
    private String newPassword;
}
