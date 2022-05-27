package com.appuntate.back.model.dto.timeInterval;

import com.appuntate.back.model.Court;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TimeIntervalRequestDTO {
    
    private long courtId;
    private String date;
    
}
