package com.appuntate.back.model.dto;

import lombok.Data;

@Data
public class CenterBookingsDTO {
   
    private String bookingDate;
    private long codBooking;
    private String courtName;
    private String date;
    private boolean paid;
    private TimeIntervalDTO timeInterval; 
    private String userName;
}
