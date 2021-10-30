package com.appuntate.back.controller;


import java.util.List;

import com.appuntate.back.service.SportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SportController {
    
    @Autowired
    private SportService sportService;

    @GetMapping("/getSportsNames")
    public List<String> getSportsNames() {
        return sportService.getSportsNames();
    }
}
