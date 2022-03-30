package com.appuntate.back.controller;

import com.appuntate.back.exceptionHandler.exceptions.forbidden.SingUpEventForbiddenException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.EventNotFoundException;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.service.EventUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EventUserController {

    @Autowired
    private EventUserService eventUserService;
    
    @PutMapping("/singUp/{eventId}/{userId}")
    public ConfirmationOutputMap singUp(@PathVariable long eventId, @PathVariable long userId) throws SingUpEventForbiddenException, EventNotFoundException {
        return eventUserService.singUp(eventId, userId);
    }

    @DeleteMapping("/cancelInscription/{eventId}/{userId}")
    public ConfirmationOutputMap cancelInscription(@PathVariable long eventId, @PathVariable long userId) throws SingUpEventForbiddenException, EventNotFoundException {
        return eventUserService.cancelInscription(eventId, userId);
    }

}
