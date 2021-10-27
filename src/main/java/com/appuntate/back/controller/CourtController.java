package com.appuntate.back.controller;

import java.util.List;

import com.appuntate.back.model.Court;
import com.appuntate.back.model.criteria.CourtCriteria;
import com.appuntate.back.model.dto.CourtFilterDTO;
import com.appuntate.back.service.CourtService;
import com.appuntate.back.service.criteria.CourtCriteriaService;

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

    @Autowired
    private CourtCriteriaService courtCriteriaService;

    @PostMapping("/getCourtsByFilters")
    public List<Court> getCourtsByFilters(@RequestBody String s) {
        CourtFilterDTO courtFilterDTO = new CourtFilterDTO();
        CourtCriteria courtCriteria = courtCriteriaService.createCriteria(courtFilterDTO);
        return null;
    }
    
}
