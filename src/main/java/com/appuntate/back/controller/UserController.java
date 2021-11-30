package com.appuntate.back.controller;

import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.LoginDTO;
import com.appuntate.back.model.dto.UserDTO;
import com.appuntate.back.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ConfirmationOutputMap login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }
    
    @PostMapping("/updateUser")
    public ConfirmationOutputMap updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

}
