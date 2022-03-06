package com.appuntate.back.model.dto.event;

import lombok.Data;

@Data
public class EventFilterDTO {
    
    private String sport;
    private Double longitude;
    private Double latitude;
}
