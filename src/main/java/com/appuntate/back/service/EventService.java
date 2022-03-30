package com.appuntate.back.service;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityNotFoundException;

import com.appuntate.back.exceptionHandler.exceptions.forbidden.SingUpEventForbiddenException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.EventByFilterNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.EventNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.UserIdNotFoundException;
import com.appuntate.back.mapper.event.EventRequestMapper;
import com.appuntate.back.mapper.event.EventResponseMapper;
import com.appuntate.back.model.Event;
import com.appuntate.back.model.User;
import com.appuntate.back.model.criteria.EventCriteria;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.event.EventFilterDTO;
import com.appuntate.back.model.dto.event.EventRequestDTO;
import com.appuntate.back.model.dto.event.EventResponseDTO;
import com.appuntate.back.repository.EventRepository;
import com.appuntate.back.service.criteria.EventCriteriaService;
import com.appuntate.back.service.specification.EventSpecificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventRequestMapper eventRequestMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private EventPhotoService eventPhotoService;

    @Autowired
    private EventCriteriaService eventCriteriaService;

    @Autowired
    private EventSpecificationService eventSpecificationService;

    @Autowired
    private EventResponseMapper eventResponseMapper;


    public Event getByEventId(long eventId) {
        return eventRepository.getById(eventId);
    }

    public ConfirmationOutputMap saveEvent(EventRequestDTO eventRequestDTO) {
        Event event = eventRequestMapper.DtoToEntity(eventRequestDTO);
        eventPhotoService.setEventToEventPhoto(event);
        eventRepository.save(event);
        return new ConfirmationOutputMap(true, "Evento creado correctamente");
    }

    public List<EventResponseDTO> getEventsByFilters(EventFilterDTO eventFilterDTO) throws EventByFilterNotFoundException {
        EventCriteria eventCriteria = eventCriteriaService.createCriteria(eventFilterDTO);
        List<Event> events = eventRepository.findAll(eventSpecificationService.createSpecification(eventCriteria));
        if(!events.isEmpty()) return eventResponseMapper.entitiesToDTOs(events);
        throw new EventByFilterNotFoundException();
    }

    public List<EventResponseDTO> getUserEvents(long userId) throws UserIdNotFoundException {
        List<Event> events = eventRepository.findByEventUserUserId(userId);
        if(events.isEmpty()) throw new UserIdNotFoundException(userId);
        return eventResponseMapper.entitiesToDTOs(events);
    }

}
