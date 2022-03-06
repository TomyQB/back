package com.appuntate.back.exceptionHandler.exceptions.notFound;

public class EventNotFoundException extends Exception {
    
    public static final String DESCRIPTION = "No se ha encontrado ningún evento con id: ";

    public EventNotFoundException() {
        super(DESCRIPTION);
    }

    public EventNotFoundException(long detail) {
        super(DESCRIPTION + ": " + detail);
    }
}
