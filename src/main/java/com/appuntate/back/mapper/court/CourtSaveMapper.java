package com.appuntate.back.mapper.court;

import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.model.Court;
import com.appuntate.back.model.dto.court.CourtSaveDTO;
import com.appuntate.back.service.HourConverter;
import com.appuntate.back.service.SportService;
import com.appuntate.back.service.TimeIntervalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourtSaveMapper implements IMapper<Court, CourtSaveDTO> {

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

        if(dto.getCourtId() != 0) court.setCourtId(dto.getCourtId());
        court.setPrice(dto.getPrice());
        court.setName(dto.getName());
        court.setInterval(HourConverter.stringToHour(dto.getDuration()));
        court.setSport(sportService.getSportBySportNameAndCodCenter(dto.getSport(), dto.getCenterId()));
        court.setTimeIntervals(timeIntervalService.createTimeIntervalByHours(dto, court));

        return court;
    }

    @Override
    public List<CourtSaveDTO> entitiesToDTOs(List<Court> entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Court> DtosToEntities(List<CourtSaveDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
