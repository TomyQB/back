package com.appuntate.back.security.mapper;

import java.util.List;
import java.util.Objects;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.security.dto.JwtDTO;
import com.appuntate.back.security.dto.LoginRequestDTO;
import com.appuntate.back.security.jwt.JwtProvider;
import com.appuntate.back.security.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtMapper implements IMapper<User, JwtDTO> {
        
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private RolMapper rolMapper;
    

    @Override
    public JwtDTO entityToDTO(User entity) {
        if(Objects.isNull(entity)) return null;

        JwtDTO jwtDTO = new JwtDTO();

        jwtDTO.setUserId(entity.getUserId());
        jwtDTO.setName(entity.getName());
        jwtDTO.setSurnames(entity.getLastName());
        jwtDTO.setUserName(entity.getUserName());
        jwtDTO.setEmail(entity.getEmail());
        jwtDTO.setPhoneNumber(entity.getPhone());
        jwtDTO.setPhoto(entity.getImage());
        jwtDTO.setRols(rolMapper.entitiesToDTOs(entity.getRols()));

        return jwtDTO;
    }

    @Override
    public User DtoToEntity(JwtDTO dto) {
        User user = new User();

        if(dto.getUserId() != 0) user.setUserId(dto.getUserId());
        user.setName(dto.getName());
        user.setLastName(dto.getSurnames());
        user.setUserName((dto.getUserName()));
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhoneNumber());
        user.setImage(dto.getPhoto());

        return user; 
    }

    @Override
    public List<JwtDTO> entitiesToDTOs(List<User> entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> DtosToEntities(List<JwtDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }

    
    public JwtDTO entityToDTOJwt(User entity, UserDetails userDetails) {
        if(Objects.isNull(entity)) return null;

        JwtDTO jwtDTO = new JwtDTO();

        jwtDTO.setUserId(entity.getUserId());
        jwtDTO.setName(entity.getName());
        jwtDTO.setSurnames(entity.getLastName());
        jwtDTO.setUserName(entity.getUserName());
        jwtDTO.setEmail(entity.getEmail());
        jwtDTO.setPhoneNumber(entity.getPhone());
        jwtDTO.setPhoto(entity.getImage());

        return jwtDTO;
    }

    public JwtDTO setJwtInfo(JwtDTO jwtDTO, String password) {
        
        Authentication authentication =
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtDTO.getUserName(), password));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        jwtDTO.setToken(getJwtToken(authentication));

        return jwtDTO;
    }

    
    private String getJwtToken(Authentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtProvider.generateToken(authentication);
    }
       
    private UserDetails getJwtDetails(Authentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return (UserDetails) authentication.getPrincipal();
    }
    
}
