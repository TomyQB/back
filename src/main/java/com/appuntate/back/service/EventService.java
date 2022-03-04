package com.appuntate.back.service;

import com.appuntate.back.mapper.event.EventRequestMapper;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.event.EventRequestDTO;
import com.appuntate.back.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventRequestMapper eventRequestMapper;

    public ConfirmationOutputMap saveEvent(EventRequestDTO eventRequestDTO) {
        eventRepository.save(eventRequestMapper.DtoToEntity(eventRequestDTO));
        return new ConfirmationOutputMap(true, "Evento creado correctamente");
    }
}
