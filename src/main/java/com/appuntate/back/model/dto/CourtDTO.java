package com.appuntate.back.model.dto;

import java.util.List;

import com.appuntate.back.model.TimeInterval;

import lombok.Data;

@Data
public class CourtDTO {

    private long codCourt;
    private String name;
    private String interval;
    private Double valoration;
    private String centerName;
    private List<TimeIntervalDTO> timeIntervals;
    
}
