package com.appuntate.back.service;

import com.appuntate.back.mapper.UserMapper;
import com.appuntate.back.model.User;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.LoginDTO;
import com.appuntate.back.model.dto.UserDTO;
import com.appuntate.back.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public User getUserByCodUser(long codUser) {
        return userRepository.getById(codUser);
    }

    public UserDTO getUserDTOByCodUser(long codUser) {
        return userMapper.entityToDTO(userRepository.getById(codUser));
    }

    public ConfirmationOutputMap login(LoginDTO loginDTO) {
        
        User user = this.userRepository.findByEmailAndPasswordAndAdmin(loginDTO.getEmail(), loginDTO.getPassword(), loginDTO.getIsAdmin());

        ConfirmationOutputMap confirmation = new ConfirmationOutputMap(false, "Error en el inicio de sesión", 0);

        if (user != null) {
            confirmation.setId(user.getCodUsuario());
            confirmation.setOk(true);
            confirmation.setMessage("Inicio de sesión realizado correctamente");

            return confirmation;
        }

        return confirmation;
    }

    public ConfirmationOutputMap register(UserDTO userDTO) {
        ConfirmationOutputMap confirmation = new ConfirmationOutputMap(false, "Error en el registro", 0);

        if (this.userRepository.findByEmail(userDTO.getEmail()) == null) {

            User user = this.userRepository.save(userMapper.DtoToEntity(userDTO));

            if (user != null) {
                confirmation.setId(user.getCodUsuario());
                confirmation.setOk(true);
                confirmation.setMessage("Registro realizado correctamente");

                return confirmation;
            }

            return confirmation;
        }
        return confirmation;

    }

    public ConfirmationOutputMap updateUser(UserDTO userDTO) {
        ConfirmationOutputMap confirmation = new ConfirmationOutputMap(false, "Error actualizando usuario", 0);

        if (this.userRepository.findById(userDTO.getId()) != null) {

            User user = this.userRepository.save(userMapper.DtoToEntity(userDTO));

            if (user != null) {
                confirmation.setId(user.getCodUsuario());
                confirmation.setOk(true);
                confirmation.setMessage("Usuario actualizado correctamente");

                return confirmation;
            }

            return confirmation;
        }
        return confirmation;

    }
}
