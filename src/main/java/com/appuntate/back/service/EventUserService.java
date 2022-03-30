package com.appuntate.back.service;

import java.util.Objects;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import com.appuntate.back.exceptionHandler.exceptions.forbidden.SingUpEventForbiddenException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.EventNotFoundException;
import com.appuntate.back.model.Event;
import com.appuntate.back.model.EventUser;
import com.appuntate.back.model.User;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.repository.EventUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventUserService {
    
    @Autowired
    private EventUserRepository eventUserRepository;

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;
    
    public ConfirmationOutputMap singUp(long eventId, long userId) throws SingUpEventForbiddenException, EventNotFoundException {
        
        try {
            Event event = eventService.getByEventId(eventId);
            User user = userService.getUserById(userId);
                 
            if(Objects.nonNull(eventUserRepository.findByEventIdAndUserId(eventId, userId)))
                throw new SingUpEventForbiddenException(Long.toString(userId));

            eventUserRepository.save(new EventUser(eventId, userId, event, user));
            return new ConfirmationOutputMap(true, "Usuario inscrito correctamente al evento '" + event.getName());
        } catch (EntityNotFoundException e) {
            throw new EventNotFoundException(eventId);
        }   
    }

    @Transactional
    public ConfirmationOutputMap cancelInscription(long eventId, long userId) {
        eventUserRepository.deleteByEventIdAndUserId(eventId, userId);
        return new ConfirmationOutputMap(true, "Se ha cancelado correctamente la inscripción al evento '" + eventId);
    }
}
