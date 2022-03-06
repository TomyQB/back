package com.appuntate.back.controller;


import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.forbidden.SingUpEventForbiddenException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.EventByFilterNotFoundException;
import com.appuntate.back.model.Event;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.event.EventFilterDTO;
import com.appuntate.back.model.dto.event.EventRequestDTO;
import com.appuntate.back.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @PutMapping("/singUp/{eventId}/{userId}")
    public ConfirmationOutputMap singUp(@PathVariable long eventId, @PathVariable long userId) throws SingUpEventForbiddenException {
        return eventService.singUp(eventId, userId);
    }

    @PostMapping("/getEvents")
    public List<Event> getEvents(@RequestBody EventFilterDTO eventFilterDTO) throws EventByFilterNotFoundException {
        return eventService.getEventsByFilters(eventFilterDTO);
    }
    
}
