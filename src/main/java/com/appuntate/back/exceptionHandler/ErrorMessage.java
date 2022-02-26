package com.appuntate.back.exceptionHandler;

import lombok.Data;

@Data
public class ErrorMessage {

    private String exception;
    private String message;
    private String path;

    public ErrorMessage(Exception exception, String path) {
        this(exception.getClass().getSimpleName(), exception.getMessage(), path);
    }

    public ErrorMessage(String exception, String message, String path) {
        this.exception = exception;
        this.message = message;
        this.path = path;
    }

    @Override
    public String toString() {
        return "ErrorMessage [exception=" + exception + ", message=" + message + ", path=" + path + "]";
    }
    
}
