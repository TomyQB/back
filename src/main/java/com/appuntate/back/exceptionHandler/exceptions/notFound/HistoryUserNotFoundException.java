package com.appuntate.back.exceptionHandler.exceptions.notFound;

public class HistoryUserNotFoundException extends Exception {
    
    public static final String DESCRIPTION = "No se han encontrado reservas para el usuario con id";

    public HistoryUserNotFoundException() {
        super(DESCRIPTION);
    }

    public HistoryUserNotFoundException(String detail) {
        super(DESCRIPTION + ": " + detail);
    }
}
