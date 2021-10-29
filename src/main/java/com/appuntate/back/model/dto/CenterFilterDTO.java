package com.appuntate.back.model.dto;

import lombok.Data;

@Data
public class CenterFilterDTO {

    private String town;
    private String sport;
    private String hour;

    public CenterFilterDTO(String town, String sport, String hour) {
        this.town = town;
        this.sport = sport;
        this.hour = hour;
    }
    
}
