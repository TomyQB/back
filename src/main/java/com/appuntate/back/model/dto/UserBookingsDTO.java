package com.appuntate.back.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserBookingsDTO {

    private String bookingDate;
    private long codBooking;
    private String courtName;
    private String date;
    private boolean paid;
    private TimeIntervalDTO timeInterval;

}
