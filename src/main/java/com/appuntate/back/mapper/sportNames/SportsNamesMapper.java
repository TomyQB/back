package com.appuntate.back.mapper.sportNames;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.model.SportsNames;
import com.appuntate.back.model.dto.sportName.SportsNamesResponseDTO;

import org.springframework.stereotype.Service;

@Service
public class SportsNamesMapper implements IMapper<SportsNames, SportsNamesResponseDTO> {


    @Override
    public SportsNamesResponseDTO entityToDTO(SportsNames entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SportsNames DtoToEntity(SportsNamesResponseDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SportsNamesResponseDTO> entitiesToDTOs(List<SportsNames> entity) {

        List<SportsNamesResponseDTO> sportsNamesDTOs = new ArrayList<>();

        for (SportsNames sportsNames : entity) {
            SportsNamesResponseDTO sportsNamesDTO = new SportsNamesResponseDTO(sportsNames.getName(), sportsNames.getPhoto());
            sportsNamesDTOs.add(sportsNamesDTO);
        }

        return sportsNamesDTOs;
    }

    @Override
    public List<SportsNames> DtosToEntities(List<SportsNamesResponseDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
