package com.appuntate.back.model.dto;


import lombok.Data;

@Data
public class CourtSaveDTO {

    private long id;
    private long codCenter;
    private double price;
    private String sportName;
    private String name;
    private String startHour;
    private String endHour;
    private String interval;


    public CourtSaveDTO(long id, long codCenter, String sportName, String name, String startHour, String endHour, String interval) {
        this.id = id;
        this.codCenter = codCenter;
        this.sportName = sportName;
        this.name = name;
        this.startHour = startHour;
        this.endHour = endHour;
        this.interval = interval;
    }
    
}
