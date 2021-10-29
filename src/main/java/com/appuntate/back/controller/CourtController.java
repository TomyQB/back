package com.appuntate.back.controller;

import java.util.List;

import com.appuntate.back.model.Court;
import com.appuntate.back.model.dto.CourtDTO;
import com.appuntate.back.service.CourtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CourtController {

    @Autowired
    private CourtService courtService;

    @PostMapping("/addCourt")
    public void addCourt(@RequestBody String s) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        CourtDTO courtDTO = new CourtDTO(0, 1, "Nueva pista de padel", "09:30", "22:00", "01:30");
        courtService.addCourt(courtDTO);
    }
    
}
