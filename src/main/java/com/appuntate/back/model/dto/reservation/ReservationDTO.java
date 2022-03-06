package com.appuntate.back.model.dto.reservation;

import lombok.Data;

@Data
public class ReservationDTO {

    private long centerId;
    private long userId;
    private long courtId;
    private String date;
    private String hour;
    private boolean isPaid;

}
