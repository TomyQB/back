package com.appuntate.back.model.dto.event;

import java.util.List;

import com.appuntate.back.model.dto.cloudinary.CloudinaryDTO;

import lombok.Data;

@Data
public class EventRequestDTO {

    private long eventId;
    private long sportId;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String startHour;
    private String endHour;
    private CloudinaryDTO photo;
    private Double price;
    private int competitorAmount;

}
