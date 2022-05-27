package com.appuntate.back.mapper.court;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.mapper.timeInterval.TimeIntervalMapper;
import com.appuntate.back.model.Court;
import com.appuntate.back.model.dto.court.CourtDTO;
import com.appuntate.back.repository.CenterRepository;
import com.appuntate.back.service.CenterService;
import com.appuntate.back.service.HourConverter;
import com.appuntate.back.service.TimeIntervalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourtMapper implements IMapper<Court, CourtDTO> {

    @Autowired
    private TimeIntervalMapper timeIntervalMapper;

    @Autowired
    private TimeIntervalService timeIntervalService;

    @Override
    public CourtDTO entityToDTO(Court entity) {
        CourtDTO courtDTO = new CourtDTO();
        
        courtDTO.setCourtId(entity.getCourtId());
        courtDTO.setInterval(HourConverter.hourToString(entity.getInterval()));
        courtDTO.setName(entity.getName());
        courtDTO.setTimeIntervals(timeIntervalMapper.entitiesToDTOs(entity.getTimeIntervals()));

        return courtDTO;
    }

    @Override
    public Court DtoToEntity(CourtDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CourtDTO> entitiesToDTOs(List<Court> entity) {
        List<CourtDTO> courtDTOs = new ArrayList<>();

        for (Court court : entity) {
            CourtDTO courtDTO = new CourtDTO();
    
            courtDTO.setCourtId(court.getCourtId());
            courtDTO.setInterval(HourConverter.hourToString(court.getInterval()));
            courtDTO.setName(court.getName());
            courtDTO.setTimeIntervals(timeIntervalMapper.entitiesToDTOs(court.getTimeIntervals()));
            
            courtDTOs.add(courtDTO);
        }

        return courtDTOs;
    }

    @Override
    public List<Court> DtosToEntities(List<CourtDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }
        
    public List<CourtDTO> entitiesToDTOsDateAndHour(List<Court> entity, String date, String hour) {
        List<CourtDTO> courtDTOs = new ArrayList<>();

        for (Court court : entity) {
            CourtDTO courtDTO = new CourtDTO();
    
            courtDTO.setCourtId(court.getCourtId());
            courtDTO.setInterval(HourConverter.hourToString(court.getInterval()));
            courtDTO.setName(court.getName());
            courtDTO.setPrice(court.getPrice());
            courtDTO.setTimeIntervals(timeIntervalMapper.entitiesToDTOs(timeIntervalService.getAvailableTimeIntervalsByDateAndHour(court.getCourtId(), date, hour)));
            courtDTO.setSport(court.getSport().getSportName().getName());
            
            courtDTOs.add(courtDTO);
        }

        return courtDTOs;
    }
    
    public List<CourtDTO> entitiesToDTOsDate(List<Court> entity, String date) {
        List<CourtDTO> courtDTOs = new ArrayList<>();

        for (Court court : entity) {
            CourtDTO courtDTO = new CourtDTO();
    
            courtDTO.setCourtId(court.getCourtId());
            courtDTO.setInterval(HourConverter.hourToString(court.getInterval()));
            courtDTO.setName(court.getName());
            courtDTO.setPrice(court.getPrice());
            courtDTO.setTimeIntervals(timeIntervalMapper.entitiesToDTOs(timeIntervalService.getAvailableTimeIntervalsByDate(court.getCourtId(), date)));
            
            courtDTOs.add(courtDTO);
        }

        return courtDTOs;
    }
    
}
