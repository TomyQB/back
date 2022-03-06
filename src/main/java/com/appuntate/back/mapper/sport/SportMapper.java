package com.appuntate.back.mapper.sport;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.mapper.court.CourtMapper;
import com.appuntate.back.mapper.sportNames.SportsNamesMapper;
import com.appuntate.back.model.Sport;
import com.appuntate.back.model.dto.sport.SportDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportMapper implements IMapper<Sport, SportDTO> {

    @Autowired
    private SportsNamesMapper sportsNamesMapper;

    @Autowired
    private CourtMapper courtMapper;

    @Override
    public SportDTO entityToDTO(Sport entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Sport DtoToEntity(SportDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SportDTO> entitiesToDTOs(List<Sport> entities) {
        List<SportDTO> sportDTOs = new ArrayList<>();

        for(Sport sport : entities) {
            SportDTO sportDTO = new SportDTO();

            sportDTO.setSportId(sport.getSportId());
            sportDTO.setName(sport.getSportName().getName());
            sportDTO.setPhoto(sport.getSportName().getPhoto());
            sportDTO.setCourts(courtMapper.entitiesToDTOs(sport.getCourts()));

            sportDTOs.add(sportDTO);
        }

        return sportDTOs;
    }

    @Override
    public List<Sport> DtosToEntities(List<SportDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }
   
    public List<SportDTO> entitiesToDTOsNotReserved(List<Sport> entities, String date) {
        List<SportDTO> sportDTOs = new ArrayList<>();

        for(Sport sport : entities) {
            SportDTO sportDTO = new SportDTO();

            sportDTO.setSportId(sport.getSportId());
            sportDTO.setName(sport.getSportName().getName());
            sportDTO.setPhoto(sport.getSportName().getPhoto());
            sportDTO.setCourts(courtMapper.entitiesToDTOsNotReserved(sport.getCourts(), date));

            sportDTOs.add(sportDTO);
        }

        return sportDTOs;
    } 


}
