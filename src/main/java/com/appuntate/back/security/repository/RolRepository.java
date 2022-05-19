package com.appuntate.back.security.repository;


import com.appuntate.back.security.enums.RolName;
import com.appuntate.back.security.model.Rol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {

    Rol findByRolName(RolName rolName);
    
}
