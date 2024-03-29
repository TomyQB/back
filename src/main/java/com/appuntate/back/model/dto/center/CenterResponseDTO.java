package com.appuntate.back.model.dto.center;

import java.util.List;


import lombok.Data;

@Data
public class CenterResponseDTO {

    private long centerId;
    private String photo;
    private String name;
    private double minimumPrice;
    private double distance;
    private double latitude;
    private double longitude;
    private double rating;
    private List<String> availableIntervals;
    
}
