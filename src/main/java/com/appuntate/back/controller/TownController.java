package com.appuntate.back.controller;

import java.util.List;

import com.appuntate.back.service.TownService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TownController {
    
    @Autowired
    private TownService townService;

    @GetMapping("/getTownNames")
    public List<String> getTownNames(){
        return townService.getTowns();
    }
}
