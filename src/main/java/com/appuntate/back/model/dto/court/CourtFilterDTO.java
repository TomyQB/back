package com.appuntate.back.model.dto.court;

import lombok.Data;

@Data
public class CourtFilterDTO {

    private long centerId;
    private String date;
    private String hour;
    private String sport;
    
}
