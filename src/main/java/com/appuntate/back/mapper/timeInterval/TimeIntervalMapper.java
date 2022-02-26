package com.appuntate.back.mapper.timeInterval;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.model.TimeInterval;
import com.appuntate.back.model.dto.timeInterval.TimeIntervalDTO;
import com.appuntate.back.service.HourConverter;

import org.springframework.stereotype.Service;

@Service
public class TimeIntervalMapper implements IMapper<TimeInterval, TimeIntervalDTO> {

    @Override
    public TimeIntervalDTO entityToDTO(TimeInterval entity) {
        TimeIntervalDTO timeIntervalDTO = new TimeIntervalDTO();

        timeIntervalDTO.setTimeIntervalId(entity.getTimeIntervalId());
        timeIntervalDTO.setStartHour(HourConverter.hourToString(entity.getStartHour()));
        timeIntervalDTO.setEndHour(HourConverter.hourToString(entity.getEndHour()));

        return timeIntervalDTO;
    }

    @Override
    public TimeInterval DtoToEntity(TimeIntervalDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TimeIntervalDTO> entitiesToDTOs(List<TimeInterval> entity) {
        List<TimeIntervalDTO> timeIntervalDTOs = new ArrayList<>();

        for (TimeInterval timeInterval : entity) {
            TimeIntervalDTO timeIntervalDTO = new TimeIntervalDTO();

            timeIntervalDTO.setTimeIntervalId(timeInterval.getTimeIntervalId());
            timeIntervalDTO.setStartHour(HourConverter.hourToString(timeInterval.getStartHour()));
            timeIntervalDTO.setEndHour(HourConverter.hourToString(timeInterval.getEndHour()));

            timeIntervalDTOs.add(timeIntervalDTO);
        }

        return timeIntervalDTOs;
    }

    @Override
    public List<TimeInterval> DtosToEntities(List<TimeIntervalDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
