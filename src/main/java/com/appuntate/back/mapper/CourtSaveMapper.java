package com.appuntate.back.mapper;

import com.appuntate.back.model.Court;
import com.appuntate.back.model.dto.CourtSaveDTO;
import com.appuntate.back.service.SportService;
import com.appuntate.back.service.TimeIntervalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourtSaveMapper implements Mapper<Court, CourtSaveDTO> {

    @Autowired
    private SportService sportService;
    
    @Autowired
    private TimeIntervalService timeIntervalService;

    @Override
    public CourtSaveDTO entityToDTO(Court entity) {
        
        return null;
    }

    @Override
    public Court DtoToEntity(CourtSaveDTO dto) {
        Court court = new Court();

        if(dto.getId() != 0) court.setCodCourt(dto.getId());
        court.setName(dto.getName());
        court.setSport(sportService.getSportBySportNameAndCodCenter(dto.getSportName(), dto.getCodCenter()));
        court.setTimeIntervals(timeIntervalService.createTimeIntervalByHours(dto, court));



        return court;
    }
    
}
