package com.appuntate.back.model.dto;


import lombok.Data;

@Data
public class UserBookingsDTO {

    private String bookingDate;
    private long codBooking;
    private String courtName;
    private long codCourt;
    private String date;
    private boolean paid;
    private TimeIntervalDTO timeInterval;

}
