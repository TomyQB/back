package com.appuntate.back.model.dto.court;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourtSaveDTO {

    private long id;
    private long centerId;
    private double price;
    private String sportName;
    private String name;
    private String startHour;
    private String endHour;
    private String interval;

}
