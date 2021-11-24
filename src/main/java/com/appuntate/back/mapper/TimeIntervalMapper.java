package com.appuntate.back.mapper;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.model.TimeInterval;
import com.appuntate.back.model.dto.TimeIntervalDTO;
import com.appuntate.back.service.HourConverter;

import org.springframework.stereotype.Service;

@Service
public class TimeIntervalMapper implements Mapper<List<TimeInterval>, List<TimeIntervalDTO>> {

    @Override
    public List<TimeIntervalDTO> entityToDTO(List<TimeInterval> entity) {
        List<TimeIntervalDTO> timeIntervalDTOs = new ArrayList<>();

        for (TimeInterval timeInterval : entity) {
            TimeIntervalDTO timeIntervalDTO = new TimeIntervalDTO();

            timeIntervalDTO.setCodTimeInterval(timeInterval.getCodTimeInterval());
            timeIntervalDTO.setStartHour(HourConverter.hourToString(timeInterval.getStartHour()));
            timeIntervalDTO.setEndHour(HourConverter.hourToString(timeInterval.getEndHour()));

            timeIntervalDTOs.add(timeIntervalDTO);
        }

        return timeIntervalDTOs;
    }

    @Override
    public List<TimeInterval> DtoToEntity(List<TimeIntervalDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
