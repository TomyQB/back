package com.appuntate.back.model.dto;


import lombok.Data;

@Data
public class CourtDTO {

    private long id;
    private long sportId;
    private String name;
    private String startHour;
    private String endHour;
    private String interval;


    public CourtDTO(long id, long sportId, String name, String startHour, String endHour, String interval) {
        this.id = id;
        this.sportId = sportId;
        this.name = name;
        this.startHour = startHour;
        this.endHour = endHour;
        this.interval = interval;
    }
    
}
