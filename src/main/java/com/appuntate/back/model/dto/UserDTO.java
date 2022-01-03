package com.appuntate.back.model.dto;

import lombok.Data;

@Data
public class UserDTO {
    
    private long id;
    private String name;
    private String lastName;
    private String userName;
    private String phone;
    private String email;
    private String password;
    private String photo;
    private boolean isAdmin;

}
