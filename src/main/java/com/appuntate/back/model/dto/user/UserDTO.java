package com.appuntate.back.model.dto.user;

import lombok.Data;

@Data
public class UserDTO {
    
    private long userId;
    private String userName;
    private String name;
    private String surnames;
    private String photo;
    private String email;
    private String phoneNumber;
    private String isAdmin;
    
}
