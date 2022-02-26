package com.appuntate.back.model.dto.timeInterval;

import lombok.Data;

@Data
public class TimeIntervalDTO {
    
    private long timeIntervalId;
    private String startHour;
    private String endHour;

}
