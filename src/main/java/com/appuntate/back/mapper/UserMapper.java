package com.appuntate.back.mapper;

import com.appuntate.back.model.User;
import com.appuntate.back.model.dto.UserDTO;

import org.springframework.stereotype.Service;

@Service
public class UserMapper implements Mapper<User, UserDTO> {

    @Override
    public UserDTO entityToDTO(User entity) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(entity.getCodUsuario());
        userDTO.setName(entity.getName());
        userDTO.setLastName(entity.getLastName());
        userDTO.setUserName(entity.getUserName());
        userDTO.setEmail(entity.getEmail());
        userDTO.setPhone(entity.getPhone());
        userDTO.setPhoto(entity.getImage());

        return userDTO;
    }

    @Override
    public User DtoToEntity(UserDTO dto) {
        User user = new User();

        if(dto.getId() != 0) user.setCodUsuario(dto.getId());
        user.setName(dto.getName());
        user.setLastName(dto.getLastName());
        user.setUserName((dto.getUserName()));
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setPassword(dto.getPassword());
        user.setImage(dto.getPhoto());

        return user; 
    }
    
}
