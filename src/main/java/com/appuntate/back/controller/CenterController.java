package com.appuntate.back.controller;

import java.util.List;

import com.appuntate.back.model.Center;
import com.appuntate.back.model.dto.CenterFilterDTO;
import com.appuntate.back.service.CenterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CenterController {
    
    @Autowired
    private CenterService centerService;


    @PostMapping("/getCentersByFilters")
    public List<Center> getCenterssByFilters(@RequestBody CenterFilterDTO centerFilterDTO) {
        return this.centerService.getCentersByFilters(centerFilterDTO);
    }
    
}
