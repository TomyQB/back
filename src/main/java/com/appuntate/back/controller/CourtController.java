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
    public void saveCourt(@RequestBody String s) {
        List<CourtDTO> courtDTOs = new ArrayList<>();
        // courtDTOs.add(new CourtDTO(0, 1, "PADEL", "Pista 1", "09:00", "23:30", "01:30"));
        // courtDTOs.add(new CourtDTO(0, 1, "PADEL", "Pista 2", "09:00", "23:30", "01:30"));
        // courtDTOs.add(new CourtDTO(0, 1, "PADEL", "Pista 3", "09:00", "23:30", "01:30"));
        // courtDTOs.add(new CourtDTO(0, 1, "TENIS", "Pista central", "09:00", "22:00", "01:00"));
        // courtDTOs.add(new CourtDTO(0, 1, "TENIS", "Pista lateral", "09:00", "22:00", "01:00"));
        // courtDTOs.add(new CourtDTO(0, 2, "PADEL", "Pista 1", "08:00", "23:30", "01:30"));
        // courtDTOs.add(new CourtDTO(0, 2, "PADEL", "Pista 2", "08:00", "23:30", "01:30"));
        courtDTOs.add(new CourtDTO(0, 2, "TENIS", "Pista rapida", "09:00", "22:00", "01:00"));

        for (CourtDTO courtDTO : courtDTOs) {
            courtService.saveCourt(courtDTO);
        }
    }
    
}
