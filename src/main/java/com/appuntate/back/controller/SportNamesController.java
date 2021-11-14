package com.appuntate.back.controller;

import java.util.List;

import com.appuntate.back.model.dto.SportsNamesDTO;
import com.appuntate.back.service.SportsNamesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SportNamesController {

    @Autowired
    private SportsNamesService sportsNamesService;

    @GetMapping("/getSportsNames")
    public List<SportsNamesDTO> getSportsNames() {
        return sportsNamesService.getSportsNames();
    }
    
}
