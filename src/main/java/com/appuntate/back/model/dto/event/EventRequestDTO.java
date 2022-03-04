package com.appuntate.back.model.dto.event;

import lombok.Data;

@Data
public class EventRequestDTO {

    private long eventId;
    private long centerId;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String startHour;
    private String endHour;
    private String photo;
    private Double price;
    private int competitorAmount;

}
