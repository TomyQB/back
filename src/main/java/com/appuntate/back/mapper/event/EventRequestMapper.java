package com.appuntate.back.mapper.event;

import java.util.List;

import javax.naming.event.EventDirContext;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.model.Event;
import com.appuntate.back.model.dto.event.EventRequestDTO;
import com.appuntate.back.service.CenterService;
import com.appuntate.back.service.HourConverter;
import com.appuntate.back.service.SportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventRequestMapper implements IMapper<Event, EventRequestDTO> {

    @Autowired
    private SportService sportService;

    @Autowired
    private EventPhotoMapper eventPhotoMapper;

    @Override
    public EventRequestDTO entityToDTO(Event entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Event DtoToEntity(EventRequestDTO dto) {
        Event event = new Event();

        if (dto.getEventId() != 0) event.setEventId(dto.getEventId());
        event.setSport(sportService.getSportById(dto.getSportId()));
        event.setName(dto.getName());
        event.setDescription(dto.getDescription());
        event.setStartDate(dto.getStartDate());
        event.setEndDate(dto.getEndDate());
        event.setStartHour(HourConverter.stringToHour(dto.getStartHour()));
        event.setEndHour(HourConverter.stringToHour(dto.getEndHour()));
        event.setPrice(dto.getPrice());
        event.setPhoto(eventPhotoMapper.DtoToEntity(dto.getPhoto()));
        event.setCompetitorAmount(dto.getCompetitorAmount());

        return event;
    }

    @Override
    public List<EventRequestDTO> entitiesToDTOs(List<Event> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Event> DtosToEntities(List<EventRequestDTO> dtos) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
