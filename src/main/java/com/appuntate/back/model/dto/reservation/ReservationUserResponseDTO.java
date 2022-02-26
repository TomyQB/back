package com.appuntate.back.model.dto.reservation;


import com.appuntate.back.model.dto.timeInterval.TimeIntervalDTO;

import lombok.Data;

@Data
public class ReservationUserResponseDTO {

    private long reservationId;
    private long courtId;
    private String courtName;
    private String centerName;
    private String date;
    private String duration;
    private boolean paid;
    private TimeIntervalDTO timeInterval;

}