package com.appuntate.back.controller;


import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.model.Court;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.CourtDTO;
import com.appuntate.back.model.dto.CourtFilterDTO;
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
    public ConfirmationOutputMap saveCourt(@RequestBody CourtDTO courtDTO) {
        return courtService.saveCourt(courtDTO);
    }

    @PostMapping("/getCourtsByFilters")
    public List<Court> getCourtsByFilter(@RequestBody CourtFilterDTO courtFilterDTO) {
        return courtService.getCourtsByFilter(courtFilterDTO);
    }
    
}
