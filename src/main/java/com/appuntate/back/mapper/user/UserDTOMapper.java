package com.appuntate.back.mapper.user;

import java.util.List;
import java.util.Objects;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.model.User;
import com.appuntate.back.model.dto.user.UserDTO;

import org.springframework.stereotype.Service;

@Service
public class UserDTOMapper implements IMapper<User, UserDTO> {

    @Override
    public UserDTO entityToDTO(User entity) {
        if(Objects.isNull(entity)) return null;

        UserDTO userDTO = new UserDTO();

        userDTO.setUserId(entity.getUserId());
        userDTO.setName(entity.getName());
        userDTO.setSurnames(entity.getLastName());
        userDTO.setUserName(entity.getUserName());
        userDTO.setEmail(entity.getEmail());
        userDTO.setPhoneNumber(entity.getPhone());
        userDTO.setPhoto(entity.getImage());
        userDTO.setIsAdmin(entity.getAdmin());

        return userDTO;
    }

    @Override
    public User DtoToEntity(UserDTO dto) {
        User user = new User();

        if(dto.getUserId() != 0) user.setUserId(dto.getUserId());
        user.setName(dto.getName());
        user.setLastName(dto.getSurnames());
        user.setUserName((dto.getUserName()));
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhoneNumber());
        user.setImage(dto.getPhoto());
        user.setAdmin("false");

        return user; 
    }

    @Override
    public List<UserDTO> entitiesToDTOs(List<User> entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> DtosToEntities(List<UserDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
