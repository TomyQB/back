package com.appuntate.back.controller;


import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.badRequest.TimeIntervalCreateException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.CourtByFilterNotFoundException;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.court.CourtDTO;
import com.appuntate.back.model.dto.court.CourtRequestDTO;
import com.appuntate.back.model.dto.court.CourtResponseDTO;
import com.appuntate.back.model.dto.court.CourtSaveDTO;
import com.appuntate.back.service.CourtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ConfirmationOutputMap saveCourt(@RequestBody CourtSaveDTO courtDTO) throws TimeIntervalCreateException {
        return courtService.saveCourt(courtDTO);
    }
    
    @PostMapping("/getAvailableCourts")
    public List<CourtResponseDTO> getCourtByDate(@RequestBody CourtRequestDTO courtInputDTO) {
        return courtService.getCourtByDate(courtInputDTO);
    }

    @PostMapping("/getCenterCourtsByFilter")
    public List<CourtDTO> getCenterCourtsByFilter(@RequestBody CourtRequestDTO courtFilterDTO) throws CourtByFilterNotFoundException {
       return courtService.getCourtByFilters(courtFilterDTO);
    }

    @PostMapping("/admin/getCenterCourts")
    public List<CourtDTO> getAdminCourts(@RequestBody CourtRequestDTO courtRequestDTO) throws CourtByFilterNotFoundException {
        return courtService.getCourtByFilters(courtRequestDTO);
    }

    @DeleteMapping("/deleteCourt/{courtId}")
    public ConfirmationOutputMap deleteCourt(@PathVariable long courtId) {
        return courtService.deleteCourt(courtId);
    }

}
