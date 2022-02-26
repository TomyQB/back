package com.appuntate.back.model.dto.reservation;

import lombok.Data;

@Data
public class ReservationDTO {

    private String reservationDate;
    private String playDate;
    private boolean isPaid;
    private long courtId;
    private long timeIntervalId;
    private long dniUser;

    
    public ReservationDTO(String reservationDate, String playDate, boolean isPaid, long courtId, long timeIntervalId,
            long dniUser) {
        this.reservationDate = reservationDate;
        this.playDate = playDate;
        this.isPaid = isPaid;
        this.courtId = courtId;
        this.timeIntervalId = timeIntervalId;
        this.dniUser = dniUser;
    }
    
}
