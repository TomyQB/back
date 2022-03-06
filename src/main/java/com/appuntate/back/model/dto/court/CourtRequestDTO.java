package com.appuntate.back.model.dto.court;

import lombok.Data;

@Data
public class CourtRequestDTO {
    
    private long centerId;
    private String hour;
    private String date;
}
