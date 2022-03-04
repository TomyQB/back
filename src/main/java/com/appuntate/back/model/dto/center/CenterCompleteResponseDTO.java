package com.appuntate.back.model.dto.center;


import java.util.List;

import com.appuntate.back.model.dto.festive.FestiveDTO;
import com.appuntate.back.model.dto.sport.SportDTO;

import lombok.Data;

@Data
public class CenterCompleteResponseDTO {

    private long centerId;
    private String name;
    private String adress;
    private Double latitude;
    private Double longitude;
    private Double rating;
    private int startHour;
    private int endHour;
    private String image;
    private List<SportDTO> sports;
    private List<FestiveDTO> festives;
    
}