package com.appuntate.back.controller;

import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.notFound.CenterWithAvailableCourtsNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.CentersByFilterNotFoundException;
import com.appuntate.back.model.dto.center.CenterCompleteResponseDTO;
import com.appuntate.back.model.dto.center.CenterFilterDTO;
import com.appuntate.back.model.dto.center.CenterResponseDTO;
import com.appuntate.back.service.CenterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CenterController {

    @Autowired
    private CenterService centerService;

    @PostMapping("/getCentersByFilters")
    public List<CenterResponseDTO> getCenterssByFilters(@RequestBody CenterFilterDTO centerFilterDTO) throws CentersByFilterNotFoundException, CenterWithAvailableCourtsNotFoundException {
        return this.centerService.getCentersByFilters(centerFilterDTO);
    }

    // @PostMapping("/getCenterByIdCourt")
    // public Center getCenterByIdCourt(@RequestBody long courtId) {
    //     return centerService.getCenterByCodCourt(courtId);
    // }

    // @GetMapping("getCenter/{centerId}")
    // public CenterCompleteResponseDTO getCenterById(@PathVariable String centerId) {
    //     return centerService.getCenterById(Integer.parseInt(centerId));
    // }

}
