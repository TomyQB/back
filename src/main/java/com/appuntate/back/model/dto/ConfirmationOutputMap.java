package com.appuntate.back.model.dto;

import lombok.Data;

@Data
public class ConfirmationOutputMap {

    private boolean isSuccesfullyCompleted;
    private String message;


    public ConfirmationOutputMap(boolean isSuccesfullyCompleted, String message) {
        this.isSuccesfullyCompleted = isSuccesfullyCompleted;
        this.message = message;
    }
    
}
