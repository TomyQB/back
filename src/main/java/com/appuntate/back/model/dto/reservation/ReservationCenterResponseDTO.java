package com.appuntate.back.model.dto.reservation;

import com.appuntate.back.model.dto.timeInterval.TimeIntervalDTO;

import lombok.Data;

@Data
public class ReservationCenterResponseDTO {
   
    private String reservationDate;
    private long reservationId;
    private String courtName;
    private String date;
    private boolean paid;
    private TimeIntervalDTO timeInterval; 
    private String userName;
}
