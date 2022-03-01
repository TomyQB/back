package com.appuntate.back.exceptionHandler.exceptions.badRequest;

public class TimeIntervalCreateException extends Exception {
    
    public static final String DESCRIPTION = "Error al crear la pista, horario no permitido";

    public TimeIntervalCreateException() {
        super(DESCRIPTION);
    }

    public TimeIntervalCreateException(String detail) {
        super(DESCRIPTION + ": " + detail);
    }
}
