package com.appuntate.back.service;

import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.forbidden.SingUpEventForbiddenException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.EventByFilterNotFoundException;
import com.appuntate.back.mapper.event.EventRequestMapper;
import com.appuntate.back.model.Event;
import com.appuntate.back.model.User;
import com.appuntate.back.model.criteria.EventCriteria;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.event.EventFilterDTO;
import com.appuntate.back.model.dto.event.EventRequestDTO;
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

    public ConfirmationOutputMap saveEvent(EventRequestDTO eventRequestDTO) {
        Event event = eventRequestMapper.DtoToEntity(eventRequestDTO);
        eventPhotoService.setEventToEventPhoto(event);
        eventRepository.save(event);
        return new ConfirmationOutputMap(true, "Evento creado correctamente");
    }

    public ConfirmationOutputMap singUp(long eventId, long userId) throws SingUpEventForbiddenException {
        Event event = eventRepository.getById(eventId);
        User user = userService.getUserById(userId);
        
        if(event.getUsers().contains(user)) throw new SingUpEventForbiddenException(Long.toString(userId));

        event.getUsers().add(user);
        event.setUsers(event.getUsers());
        eventRepository.save(event);
        return new ConfirmationOutputMap(true, "Usuario inscrito correctamente al evento '" + event.getName());
    }

    public List<Event> getEventsByFilters(EventFilterDTO eventFilterDTO) throws EventByFilterNotFoundException {
        EventCriteria eventCriteria = eventCriteriaService.createCriteria(eventFilterDTO);
        List<Event> events = eventRepository.findAll(eventSpecificationService.createSpecification(eventCriteria));
        if(!events.isEmpty()) return events;
        throw new EventByFilterNotFoundException();
    }
}
