package com.appuntate.back.mapper.event;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.model.Event;
import com.appuntate.back.model.dto.event.EventResponseDTO;
import com.appuntate.back.service.HourConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventResponseMapper implements IMapper<Event, EventResponseDTO> {

    @Autowired
    private EventPhotoMapper eventPhotoMapper;

    @Override
    public EventResponseDTO entityToDTO(Event entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Event DtoToEntity(EventResponseDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<EventResponseDTO> entitiesToDTOs(List<Event> entities) {
        List<EventResponseDTO> eventResponseDTOs = new ArrayList<>();

        for (Event event : entities) {
            EventResponseDTO eventResponseDTO = new EventResponseDTO();

            eventResponseDTO.setEventId(event.getEventId());
            eventResponseDTO.setCenterId(event.getSport().getCenter().getCenterId());
            eventResponseDTO.setCenterName(event.getSport().getCenter().getName());
            eventResponseDTO.setEventName(event.getName());
            eventResponseDTO.setDescription(event.getDescription());
            eventResponseDTO.setDate(event.getStartDate());
            eventResponseDTO.setStartHour(HourConverter.hourToString(event.getStartHour()));
            eventResponseDTO.setEndHour(HourConverter.hourToString(event.getEndHour()));
            eventResponseDTO.setCapacity(event.getCompetitorAmount());
            eventResponseDTO.setSignedUpPeople(event.getUsers().size());
            eventResponseDTO.setPhotos(eventPhotoMapper.entitiesToDTOs(event.getPhotos()));

            eventResponseDTOs.add(eventResponseDTO);
        }
        return eventResponseDTOs;
    }

    @Override
    public List<Event> DtosToEntities(List<EventResponseDTO> dtos) {
        // TODO Auto-generated method stub
        return null;
    }
        
}
