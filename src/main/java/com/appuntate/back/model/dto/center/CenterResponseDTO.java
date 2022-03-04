package com.appuntate.back.model.dto.center;

import java.util.List;

import com.appuntate.back.model.dto.timeInterval.TimeIntervalDTO;

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
    private List<Integer> availableIntervals;
    
}
