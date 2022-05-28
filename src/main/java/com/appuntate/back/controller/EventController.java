package com.appuntate.back.controller;


import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.forbidden.SingUpEventForbiddenException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.CenterIdNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.EventByFilterNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.EventNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.UserIdNotFoundException;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.event.EventFilterDTO;
import com.appuntate.back.model.dto.event.EventRequestDTO;
import com.appuntate.back.model.dto.event.EventResponseDTO;
import com.appuntate.back.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EventController {

    @Autowired
    private EventService eventService;

    @PutMapping("/saveEvent")
    public ConfirmationOutputMap saveEvent(@RequestBody EventRequestDTO eventRequestDTO) {
        return eventService.saveEvent(eventRequestDTO);        
    }

    @DeleteMapping("/deleteEvent/{eventId}")
    public ConfirmationOutputMap deleteEvent(@PathVariable long eventId) {
        return eventService.deleteEvent(eventId);
    }

    @PostMapping("/getEvents")
    public List<EventResponseDTO> getEvents(@RequestBody EventFilterDTO eventFilterDTO) throws EventByFilterNotFoundException {
        return eventService.getEventsByFilters(eventFilterDTO);
    }

    @GetMapping("/getUserEvents/{userId}")
    public List<EventResponseDTO> getUserEvents(@PathVariable long userId) throws UserIdNotFoundException {
        return eventService.getUserEvents(userId);
    }
    
    @GetMapping("/getCenterEvents/{centerId}")
    public List<EventResponseDTO> getCenterEvents(@PathVariable long centerId) throws CenterIdNotFoundException {
        return eventService.getCenterEvents(centerId);
    }
    
    
}
