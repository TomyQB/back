package com.appuntate.back.security.service;

import javax.transaction.Transactional;

import com.appuntate.back.security.enums.RolName;
import com.appuntate.back.security.model.Rol;
import com.appuntate.back.security.repository.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    
    @Autowired
    private RolRepository rolRepository;

    public Rol getByRolName(RolName rolName) {
        return rolRepository.findByRolName(rolName);
    }
}
