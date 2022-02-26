package com.appuntate.back.model.dto.center;

import lombok.Data;

@Data
public class CenterFilterDTO {

    private String sport;
    private String date;
    private String hour;
    private Double latitude;
    private Double longitude;
    private Double rating;


    public CenterFilterDTO(String sport, String date, String hour, Double latitude, Double longitude, Double rating) {
        this.sport = sport;
        this.date = date;
        this.hour = hour;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rating = rating;
    }

}
