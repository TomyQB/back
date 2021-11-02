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
    public List<Center> getCenterssByFilters(@RequestBody String s) {
        CenterFilterDTO centerFilterDTO = new CenterFilterDTO("MURCIA", "TENIS", "12:00", "29/10/2021");
        return this.centerService.getCentersByFilters(centerFilterDTO);
    }
    
}