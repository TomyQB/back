package com.appuntate.back.mapper;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.model.SportsNames;

import org.springframework.stereotype.Service;

@Service
public class SportsNamesMapper implements Mapper<List<SportsNames>, List<String>> {

    @Override
    public List<String> entityToDTO(List<SportsNames> entity) {

        List<String> names = new ArrayList<>();

        for (SportsNames sportsNames : entity) {
            names.add(sportsNames.getName());
        }

        return names;
    }

    @Override
    public List<SportsNames> DtoToEntity(List<String> dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
