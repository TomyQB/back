package com.appuntate.back.model.dto.court;

import java.util.List;

import com.appuntate.back.model.TimeInterval;
import com.appuntate.back.model.dto.timeInterval.TimeIntervalDTO;

import lombok.Data;

@Data
public class CourtDTO {

    private long courtId;
    private String name;
    private String interval;
    private Double valoration;
    private String centerName;
    private List<TimeIntervalDTO> timeIntervals;
    
}
