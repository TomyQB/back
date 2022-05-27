package com.appuntate.back.mapper.user;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.model.User;
import com.appuntate.back.model.dto.user.UserResponseDTO;

import org.springframework.stereotype.Service;

@Service
public class UserResponseDTOMapper implements IMapper<User, UserResponseDTO> {

    @Override
    public UserResponseDTO entityToDTO(User entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User DtoToEntity(UserResponseDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserResponseDTO> entitiesToDTOs(List<User> entities) {
        List<UserResponseDTO> userResponseDTOs = new ArrayList<>();

        for(User user : entities) {
            UserResponseDTO userResponseDTO = new UserResponseDTO();

            userResponseDTO.setUserId(user.getUserId());
            userResponseDTO.setUserName(user.getUserName());

            userResponseDTOs.add(userResponseDTO);
        }

        return userResponseDTOs;
    }

    @Override
    public List<User> DtosToEntities(List<UserResponseDTO> dtos) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
