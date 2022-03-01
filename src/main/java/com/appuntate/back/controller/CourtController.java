package com.appuntate.back.controller;


import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.court.CourtSaveDTO;
import com.appuntate.back.service.CourtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CourtController {

    @Autowired
    private CourtService courtService;

    @PutMapping("/saveCourt")
    public ConfirmationOutputMap saveCourt(@RequestBody CourtSaveDTO courtDTO) {
        return courtService.saveCourt(courtDTO);
    }

    // @PostMapping("/getCourtsByFilters")
    // public List<CourtDTO> getCourtsByFilter(@RequestBody CourtFilterDTO courtFilterDTO) {
    //     return courtService.getCourtsByFilter(courtFilterDTO);
    // }
    
    // @PostMapping("/getCourtByDate")
    // public CourtDTO getCourtByDate(@RequestBody CourtInputDTO courtInputDTO) {
    //     return courtService.getCourtByDate(courtInputDTO);
    // }
}
