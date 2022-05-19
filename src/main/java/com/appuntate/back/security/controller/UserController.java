package com.appuntate.back.security.controller;

import com.appuntate.back.exceptionHandler.exceptions.badRequest.UserRegisterException;
import com.appuntate.back.exceptionHandler.exceptions.badRequest.UserUpdateException;
import com.appuntate.back.exceptionHandler.exceptions.forbidden.UpdatePasswordForbiddenException;
import com.appuntate.back.exceptionHandler.exceptions.forbidden.UserAlreadyRegisterException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.UserIdNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.UserLoginNotFoundException;
import com.appuntate.back.security.dto.JwtDTO;
import com.appuntate.back.security.dto.LoginRequestDTO;
import com.appuntate.back.security.dto.UserDTO;
import com.appuntate.back.security.dto.UserPasswordRequestDTO;
import com.appuntate.back.security.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

     
    @PostMapping("/register")
    public JwtDTO register(@RequestBody UserDTO userDTO) throws UserRegisterException, UserAlreadyRegisterException {
        return userService.register(userDTO);
    }
    

    @PostMapping("/login")
    public JwtDTO login(@RequestBody LoginRequestDTO loginDTO) throws UserLoginNotFoundException {
        return userService.login(loginDTO);
    }
   

    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) throws UserUpdateException, UserIdNotFoundException {
        return userService.updateUser(userDTO);
    }

    @PatchMapping("/updatePassword")
    public UserDTO updatePassword(@RequestBody UserPasswordRequestDTO userPasswordRequestDTO) throws UpdatePasswordForbiddenException {
        return userService.updatePassword(userPasswordRequestDTO);
    }

}
