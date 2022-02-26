package com.appuntate.back.controller;

import com.appuntate.back.exceptionHandler.exceptions.badRequest.UserAlreadyRegisterException;
import com.appuntate.back.exceptionHandler.exceptions.badRequest.UserRegisterException;
import com.appuntate.back.exceptionHandler.exceptions.badRequest.UserUpdateException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.UserIdNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.UserLoginNotFoundException;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.user.LoginRequestDTO;
import com.appuntate.back.model.dto.user.UserDTO;
import com.appuntate.back.model.dto.user.UserDTO;
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
    public UserDTO login(@RequestBody LoginRequestDTO loginDTO) throws UserLoginNotFoundException {
        return userService.login(loginDTO);
    }
    
    @PostMapping("/register")
    public UserDTO register(@RequestBody UserDTO userDTO) throws UserRegisterException, UserAlreadyRegisterException {
        return userService.register(userDTO);
    }

    @PostMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) throws UserUpdateException, UserIdNotFoundException {
        return userService.updateUser(userDTO);
    }

    // @PostMapping("/getUserInfo")
    // public UserDTO getUserInfo(@RequestBody long userId) {
    //     return userService.getUserDTOByCodUser(userId);
    // }

}
