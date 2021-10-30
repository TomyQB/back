package com.appuntate.back.model.dto;

import lombok.Data;

@Data
public class CenterFilterDTO {

    private String town;
    private String sport;
    private String hour;
    private String date;

    public CenterFilterDTO(String town, String sport, String hour, String date) {
        this.town = town;
        this.sport = sport;
        this.hour = hour;
        this.date = date;
    }
    
}
