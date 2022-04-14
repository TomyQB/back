package com.appuntate.back.model.dto.history;

import com.appuntate.back.model.dto.timeInterval.TimeIntervalDTO;

import lombok.Data;


@Data
public class HistoryUserResponseDTO {

    private long reservationId;
    private long courtId;
    private long centerId;
    private String courtName;
    private String centerName;
    private String centerPhoto;
    private String date;
    private String duration;
    private boolean paid;
    private TimeIntervalDTO timeInterval;

}
