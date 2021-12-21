package com.appuntate.back.mapper;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.model.Town;

import org.springframework.stereotype.Service;

@Service
public class TownMapper implements Mapper<List<Town>, List<String>>{

    @Override
    public List<String> entityToDTO(List<Town> entity) {
        List<String> towns = new ArrayList<>();

        for (Town town : entity) {
           String s = town.getName();
           towns.add(s);
        }
        return towns;
    }

    @Override
    public List<Town> DtoToEntity(List<String> dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
