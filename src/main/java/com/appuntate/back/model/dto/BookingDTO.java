package com.appuntate.back.model.dto;

import lombok.Data;

@Data
public class BookingDTO {

    private String bookingDate;
    private String playDate;
    private boolean isPaid;
    private long codCourt;
    private long codTimeInterval;
    private long dniUser;

    
    public BookingDTO(String bookingDate, String playDate, boolean isPaid, long codCourt, long codTimeInterval,
            long dniUser) {
        this.bookingDate = bookingDate;
        this.playDate = playDate;
        this.isPaid = isPaid;
        this.codCourt = codCourt;
        this.codTimeInterval = codTimeInterval;
        this.dniUser = dniUser;
    }
    
}
