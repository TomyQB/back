package com.appuntate.back.mapper;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.model.Court;
import com.appuntate.back.model.dto.CourtDTO;
import com.appuntate.back.service.HourConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourtMapper implements Mapper<List<Court>, List<CourtDTO>> {

    @Autowired
    private TimeIntervalMapper timeIntervalMapper;

    @Override
    public List<CourtDTO> entityToDTO(List<Court> entity) {
        List<CourtDTO> courtDTOs = new ArrayList<>();

        for (Court court : entity) {
            CourtDTO courtDTO = new CourtDTO();
    
            courtDTO.setCodCourt(court.getCodCourt());
            courtDTO.setInterval(HourConverter.hourToString(court.getInterval()));
            courtDTO.setName(court.getName());
            courtDTO.setTimeIntervals(timeIntervalMapper.entityToDTO(court.getTimeIntervals()));
            
            courtDTOs.add(courtDTO);
        }

        return courtDTOs;
    }

    @Override
    public List<Court> DtoToEntity(List<CourtDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
