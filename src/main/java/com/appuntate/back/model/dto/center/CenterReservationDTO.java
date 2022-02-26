package com.appuntate.back.model.dto.center;

import com.appuntate.back.model.dto.timeInterval.TimeIntervalDTO;

import lombok.Data;

@Data
public class CenterReservationDTO {
   
    private String reservationDate;
    private long reservationId;
    private String courtName;
    private String date;
    private boolean paid;
    private TimeIntervalDTO timeInterval; 
    private String userName;
}
