package com.appuntate.back.security.mapper;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.security.enums.RolName;
import com.appuntate.back.security.model.Rol;
import com.appuntate.back.security.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolMapper implements IMapper<Rol, String> {

    @Autowired
    private RolService rolService;

    @Override
    public String entityToDTO(Rol entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Rol DtoToEntity(String dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> entitiesToDTOs(List<Rol> entities) {
        List<String> rolNames = new ArrayList<>();

        for(Rol rol : entities) {
            rolNames.add(rol.getRolName().toString());
        }

        return rolNames;
    }

    @Override
    public List<Rol> DtosToEntities(List<String> dtos) {
        List<Rol> rols = new ArrayList<>();

        for(String rol : dtos) {
            if(rol.equals("user")) rols.add(rolService.getByRolName(RolName.ROL_USER));

            else if(rol.equals("admin")) rols.add(rolService.getByRolName(RolName.ROL_ADMIN));
        }
        
        return rols;
    }
    
}
