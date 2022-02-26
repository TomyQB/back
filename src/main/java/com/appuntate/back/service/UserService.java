package com.appuntate.back.service;

import com.appuntate.back.exceptionHandler.exceptions.badRequest.UserAlreadyRegisterException;
import com.appuntate.back.exceptionHandler.exceptions.badRequest.UserRegisterException;
import com.appuntate.back.exceptionHandler.exceptions.badRequest.UserUpdateException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.UserIdNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.UserLoginNotFoundException;
import com.appuntate.back.mapper.user.UserDTOMapper;
import com.appuntate.back.model.User;
import com.appuntate.back.model.dto.user.LoginRequestDTO;
import com.appuntate.back.model.dto.user.UserDTO;
import com.appuntate.back.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDTOMapper userDTOMapper;

    public User getUserByUserId(long userId) {
        return userRepository.getById(userId);
    }

    public UserDTO getUserDTOByUserId(long userId) {
        return userDTOMapper.entityToDTO(userRepository.getById(userId));
    }

    public UserDTO login(LoginRequestDTO loginDTO) throws UserLoginNotFoundException {
        User user = this.userRepository.findByUserNameAndPasswordAndAdmin(loginDTO.getUserName(), loginDTO.getPassword(), loginDTO.getIsAdmin());
        
        if (user != null) return userDTOMapper.entityToDTO(user);
        throw new UserLoginNotFoundException();
    }

    public UserDTO register(UserDTO userDTO) throws UserRegisterException, UserAlreadyRegisterException {

        if (this.userRepository.findByEmail(userDTO.getEmail()) == null) {
            User user = this.userRepository.save(userDTOMapper.DtoToEntity(userDTO));

            if (user != null) return userDTOMapper.entityToDTO(user);
            throw new UserRegisterException();
        }

        throw new UserAlreadyRegisterException(userDTO.getEmail());
    }

    public UserDTO updateUser(UserDTO userDTO) throws UserUpdateException, UserIdNotFoundException {

        if (this.userRepository.findById(userDTO.getUserId()).isPresent()) {
            User user = this.userRepository.save(userDTOMapper.DtoToEntity(userDTO));

            if (user != null) return userDTOMapper.entityToDTO(user);
            throw new UserUpdateException();
        }

        throw new UserIdNotFoundException();

    }
}
