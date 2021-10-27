package com.appuntate.back.model.dto;

import lombok.Data;

@Data
public class CourtFilterDTO {

    private String town;
    private String sport;
    private String hour;

    public CourtFilterDTO(String town, String sport, String hour) {
        this.town = town;
        this.sport = sport;
        this.hour = hour;
    }
    
}
