package com.appuntate.back.service;

import com.appuntate.back.model.User;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.LoginDTO;
import com.appuntate.back.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User getUserByCodUser(long codUser) {
        return userRepository.getById(codUser);
    }

    public ConfirmationOutputMap login(LoginDTO loginDTO) {
        User user = this.userRepository.findUserByEmailAndPassword(loginDTO.getEmail(), loginDTO.getEmail());

        ConfirmationOutputMap confirmation = new ConfirmationOutputMap(false, "Error en el login", 0);

        if(user != null) {
            confirmation.setId(user.getCodUsuario());
            confirmation.setOk(true);
            confirmation.setMessage("Inicio de sesión realizado correctamente");

            return confirmation;
        }

        return confirmation;
    }
}
