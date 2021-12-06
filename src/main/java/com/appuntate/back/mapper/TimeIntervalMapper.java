package com.appuntate.back.mapper;

import com.appuntate.back.model.TimeInterval;
import com.appuntate.back.model.dto.TimeIntervalDTO;
import com.appuntate.back.service.HourConverter;

import org.springframework.stereotype.Service;

@Service
public class TimeIntervalMapper implements Mapper<TimeInterval, TimeIntervalDTO> {

    @Override
    public TimeIntervalDTO entityToDTO(TimeInterval entity) {
        TimeIntervalDTO timeIntervalDTO = new TimeIntervalDTO();

        timeIntervalDTO.setCodTimeInterval(entity.getCodTimeInterval());
        timeIntervalDTO.setStartHour(HourConverter.hourToString(entity.getStartHour()));
        timeIntervalDTO.setEndHour(HourConverter.hourToString(entity.getEndHour()));

        return timeIntervalDTO;
    }

    @Override
    public TimeInterval DtoToEntity(TimeIntervalDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
