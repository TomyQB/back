package com.appuntate.back.controller;

import java.util.List;

import com.appuntate.back.mapper.timeInterval.TimeIntervalMapper;
import com.appuntate.back.model.dto.timeInterval.TimeIntervalDTO;
import com.appuntate.back.model.dto.timeInterval.TimeIntervalRequestDTO;
import com.appuntate.back.service.TimeIntervalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TimeIntervalController {
    
    @Autowired
    private TimeIntervalService timeIntervalService;

    @Autowired
    private TimeIntervalMapper timeIntervalMapper;

    @PostMapping("/getCourtAvailableHours")
    public List<TimeIntervalDTO> getCourtAvailableHours(@RequestBody TimeIntervalRequestDTO timeIntervalRequestDTO) {
        return timeIntervalMapper.entitiesToDTOs(
            timeIntervalService.getAvailableTimeIntervalsByDate(timeIntervalRequestDTO.getCourtId(), timeIntervalRequestDTO.getDate()));
    }
}
