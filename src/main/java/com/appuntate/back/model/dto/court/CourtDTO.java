package com.appuntate.back.model.dto.court;

import java.util.List;

import com.appuntate.back.model.dto.timeInterval.TimeIntervalDTO;

import lombok.Data;

@Data
public class CourtDTO {

    private long courtId;
    private String name;
    private String interval;
    private Double price;
    private String sport;
    private List<TimeIntervalDTO> timeIntervals;
    
}
