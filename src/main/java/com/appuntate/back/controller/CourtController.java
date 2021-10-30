package com.appuntate.back.controller;


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

    @PostMapping("/saveCourt")
    public void saveCourt(@RequestBody String s) {
        CourtDTO courtDTO = new CourtDTO(0, 4, "Pista club", "09:00", "23:00", "01:00");
        courtService.saveCourt(courtDTO);
    }
    
}
