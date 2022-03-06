package com.appuntate.back.exceptionHandler.exceptions.notFound;

public class EventByFilterNotFoundException extends Exception {
    
    public static final String DESCRIPTION = "Ningún evento encontrado para los filtros aplicados";

    public EventByFilterNotFoundException() {
        super(DESCRIPTION);
    }

    public EventByFilterNotFoundException(String detail) {
        super(DESCRIPTION + ": " + detail);
    }
}
