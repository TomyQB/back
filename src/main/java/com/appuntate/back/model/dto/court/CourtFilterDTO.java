package com.appuntate.back.model.dto.court;

import lombok.Data;

@Data
public class CourtFilterDTO {

    private String hour;
    private String date;
    private String sport;
    private String town;
    private Double valoration;
    
}
