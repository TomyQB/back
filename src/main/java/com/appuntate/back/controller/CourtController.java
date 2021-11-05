package com.appuntate.back.controller;


import java.util.ArrayList;
import java.util.List;

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
    public void saveCourt(@RequestBody CourtDTO courtDTO) {
        courtService.saveCourt(courtDTO);
    }
    
}
