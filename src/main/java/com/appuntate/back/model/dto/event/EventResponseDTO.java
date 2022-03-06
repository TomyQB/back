package com.appuntate.back.model.dto.event;

import java.util.List;

import lombok.Data;

@Data
public class EventResponseDTO {
    
    private long eventId;
    private long centerId;
    private String centerName;
    private String eventName;
    private String description;
    private String date;
    private String startHour;
    private String endHour;
    private int capacity;
    private int signedUpPeople;
    private List<String> photos;
}
