package com.appuntate.back.model.dto;

import lombok.Data;

@Data
public class ConfirmationOutputMap {

    private boolean isOk;
    private String message;


    public ConfirmationOutputMap(boolean isOk, String message) {
        this.isOk = isOk;
        this.message = message;
    }
    
}
