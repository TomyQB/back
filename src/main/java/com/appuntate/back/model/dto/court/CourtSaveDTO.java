package com.appuntate.back.model.dto.court;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourtSaveDTO {

    private long courtId;
    private long centerId;
    private double price;
    private String sport;
    private String name;
    private String startHour;
    private String endHour;
    private String duration;

}
