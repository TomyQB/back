package com.appuntate.back.service;

import com.appuntate.back.exceptionHandler.exceptions.badRequest.UserRegisterException;
import com.appuntate.back.exceptionHandler.exceptions.badRequest.UserUpdateException;
import com.appuntate.back.exceptionHandler.exceptions.forbidden.UpdatePasswordForbiddenException;
import com.appuntate.back.exceptionHandler.exceptions.forbidden.UserAlreadyRegisterException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.UserIdNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.UserLoginNotFoundException;
import com.appuntate.back.mapper.user.UserDTOMapper;
import com.appuntate.back.model.User;
import com.appuntate.back.model.dto.user.LoginRequestDTO;
import com.appuntate.back.model.dto.user.UserDTO;
import com.appuntate.back.model.dto.user.UserPasswordRequestDTO;
import com.appuntate.back.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDTOMapper userDTOMapper;

    public User getUserById(long userId) {
        return userRepository.getById(userId);
    }

    public UserDTO getUserDTOById(long userId) {
        return userDTOMapper.entityToDTO(userRepository.getById(userId));
    }

    public UserDTO login(LoginRequestDTO loginDTO) throws UserLoginNotFoundException {
        User user = userRepository.findByUserNameAndPasswordAndAdmin(loginDTO.getUserName(), loginDTO.getPassword(), loginDTO.getIsAdmin());
        
        if (user != null) return userDTOMapper.entityToDTO(user);
        throw new UserLoginNotFoundException();
    }

    public UserDTO register(UserDTO userDTO) throws UserRegisterException, UserAlreadyRegisterException {

        if (userRepository.findByEmail(userDTO.getEmail()) == null) {
            User user = userRepository.save(userDTOMapper.DtoToEntity(userDTO));

            if (user != null) return userDTOMapper.entityToDTO(user);
            throw new UserRegisterException();
        }

        throw new UserAlreadyRegisterException(userDTO.getEmail());
    }

    public UserDTO updateUser(UserDTO userDTO) throws UserUpdateException, UserIdNotFoundException {
        User user = userRepository.findById(userDTO.getUserId()).get();

        if (user != null) {
            userDTO.setPassword(user.getPassword());
            user = userRepository.save(userDTOMapper.DtoToEntity(userDTO));

            if (user != null) return userDTOMapper.entityToDTO(user);
            throw new UserUpdateException();
        }

        throw new UserIdNotFoundException(userDTO.getUserId());

    }

    public UserDTO updatePassword(UserPasswordRequestDTO userPasswordRequestDTO) throws UpdatePasswordForbiddenException {
        User user = userRepository.findByUserIdAndPassword(userPasswordRequestDTO.getUserId(), userPasswordRequestDTO.getOldPassword());

        if(user == null) throw new UpdatePasswordForbiddenException();

        user.setPassword(userPasswordRequestDTO.getNewPassword());
        userRepository.save(user);

        return userDTOMapper.entityToDTO(user);
    }
}
