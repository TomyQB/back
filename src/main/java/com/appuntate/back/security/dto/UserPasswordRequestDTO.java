package com.appuntate.back.security.dto;
import lombok.Data;

@Data
public class UserPasswordRequestDTO {
    
    private long userId;
    private String oldPassword;
    private String newPassword;
}
