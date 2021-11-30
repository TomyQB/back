package com.appuntate.back.model.dto;

import lombok.Data;

@Data
public class ConfirmationOutputMap {

    private boolean isOk;
    private String message;
    private long id;


    public ConfirmationOutputMap(boolean isOk, String message, long id) {
        this.isOk = isOk;
        this.message = message;
        this.id = id;
    }
    
}
