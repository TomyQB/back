package com.appuntate.back.controller;

import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.badRequest.UserRegisterException;
import com.appuntate.back.exceptionHandler.exceptions.badRequest.UserUpdateException;
import com.appuntate.back.exceptionHandler.exceptions.forbidden.UpdatePasswordForbiddenException;
import com.appuntate.back.exceptionHandler.exceptions.forbidden.UserAlreadyRegisterException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.UserIdNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.UserLoginNotFoundException;
import com.appuntate.back.model.dto.user.LoginRequestDTO;
import com.appuntate.back.model.dto.user.UserDTO;
import com.appuntate.back.model.dto.user.UserPasswordRequestDTO;
import com.appuntate.back.model.dto.user.UserResponseDTO;
import com.appuntate.back.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @PutMapping("/register")
    public UserDTO register(@RequestBody UserDTO userDTO) throws UserRegisterException, UserAlreadyRegisterException {
        return userService.register(userDTO);
    }

    @PostMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) throws UserUpdateException, UserIdNotFoundException {
        return userService.updateUser(userDTO);
    }

    @PutMapping("/updatePassword")
    public UserDTO updatePassword(@RequestBody UserPasswordRequestDTO userPasswordRequestDTO) throws UpdatePasswordForbiddenException {
        return userService.updatePassword(userPasswordRequestDTO);
    }

    @GetMapping("/getUsers")
    public List<UserResponseDTO> getUsers() {
        return userService.getUsers();
    }

    // @PostMapping("/getUserInfo")
    // public UserDTO getUserInfo(@RequestBody long userId) {
    //     return userService.getUserDTOByCodUser(userId);
    // }

}
