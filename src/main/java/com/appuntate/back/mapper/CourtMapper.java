package com.appuntate.back.mapper;

import com.appuntate.back.model.Court;
import com.appuntate.back.model.dto.CourtDTO;
import com.appuntate.back.service.SportService;
import com.appuntate.back.service.TimeIntervalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourtMapper implements Mapper<Court, CourtDTO> {

    @Autowired
    private SportService sportService;
    
    @Autowired
    private TimeIntervalService timeIntervalService;

    @Override
    public CourtDTO entityToDTO(Court entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Court DtoToEntity(CourtDTO dto) {
        Court court = new Court();

        if(dto.getId() != 0) court.setCodCourt(dto.getId());
        court.setName(dto.getName());
        court.setSport(sportService.getSportById(dto.getSportId()));
        court.setTimeIntervals(timeIntervalService.createTimeIntervalByHours(dto, court));



        return court;
    }
    
}
