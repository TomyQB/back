package com.appuntate.back.controller;

import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.notFound.ReservationIdNotFoundException;
import com.appuntate.back.model.dto.sportName.SportsNamesResponseDTO;
import com.appuntate.back.service.SportsNamesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("/auth")
@CrossOrigin
public class SportNamesController {

    @Autowired
    private SportsNamesService sportsNamesService;
    
    @GetMapping("/getSportNames")
    public List<SportsNamesResponseDTO> getSportsNames() throws ReservationIdNotFoundException {
        return sportsNamesService.getSportsNames();
    }
    
}
