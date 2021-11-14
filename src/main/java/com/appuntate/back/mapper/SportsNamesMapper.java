package com.appuntate.back.mapper;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.model.SportsNames;
import com.appuntate.back.model.dto.SportsNamesDTO;

import org.springframework.stereotype.Service;

@Service
public class SportsNamesMapper implements Mapper<List<SportsNames>, List<SportsNamesDTO>> {

    @Override
    public List<SportsNamesDTO> entityToDTO(List<SportsNames> entity) {

        List<SportsNamesDTO> sportsNamesDTOs = new ArrayList<>();

        for (SportsNames sportsNames : entity) {
            SportsNamesDTO sportsNamesDTO = new SportsNamesDTO(sportsNames.getName(), sportsNames.getImage());
            sportsNamesDTOs.add(sportsNamesDTO);
        }

        return sportsNamesDTOs;
    }

    @Override
    public List<SportsNames> DtoToEntity(List<SportsNamesDTO> dto) {
        return null;
    }
    
}
