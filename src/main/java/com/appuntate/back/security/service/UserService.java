package com.appuntate.back.security.service;

import java.util.Objects;

import javax.transaction.Transactional;

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
import com.appuntate.back.security.mapper.JwtMapper;
import com.appuntate.back.security.mapper.UserDTOMapper;
import com.appuntate.back.security.model.User;
import com.appuntate.back.security.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDTOMapper userDTOMapper;

    @Autowired
    private JwtMapper jwtMapper;
    

    public User getByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public boolean existByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User getUserById(long userId) {
        return userRepository.getById(userId);
    }

    public UserDTO getUserDTOById(long userId) {
        return userDTOMapper.entityToDTO(userRepository.getById(userId));
    }

    public JwtDTO login(LoginRequestDTO loginDTO) throws UserLoginNotFoundException {

        User user = userRepository.findByUserName(loginDTO.getUserName());
        
        if (Objects.nonNull(user)) {
            JwtDTO jwtDTO = jwtMapper.entityToDTO(user);
            return jwtMapper.setJwtInfo(jwtDTO, loginDTO.getPassword());
        }
        throw new UserLoginNotFoundException();
    }

    public JwtDTO register(UserDTO userDTO) throws UserRegisterException, UserAlreadyRegisterException {

        if (!userRepository.existsByEmail(userDTO.getEmail()) && !userRepository.existsByUserName(userDTO.getUserName())) {
            User user = userRepository.saveAndFlush(userDTOMapper.DtoToEntity(userDTO));

            if (Objects.nonNull(user)) {
                JwtDTO jwtDTO = jwtMapper.entityToDTO(user);
                return jwtMapper.setJwtInfo(jwtDTO, userDTO.getPassword());
            }
            throw new UserRegisterException();
        }

        throw new UserAlreadyRegisterException(userDTO.getEmail(), userDTO.getUserName());
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
