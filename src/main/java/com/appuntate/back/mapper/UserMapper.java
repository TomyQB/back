package com.appuntate.back.mapper;

import com.appuntate.back.model.User;
import com.appuntate.back.model.dto.UserDTO;

import org.springframework.stereotype.Service;

@Service
public class UserMapper implements Mapper<User, UserDTO> {

    @Override
    public UserDTO entityToDTO(User entity) {
        // TODO Auto-generated method stub
        return null;
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
