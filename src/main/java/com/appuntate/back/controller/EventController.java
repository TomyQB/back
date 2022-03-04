package com.appuntate.back.controller;

import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.event.EventRequestDTO;
import com.appuntate.back.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    
}
