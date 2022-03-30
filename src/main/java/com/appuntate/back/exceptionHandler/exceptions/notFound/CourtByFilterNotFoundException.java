package com.appuntate.back.exceptionHandler.exceptions.notFound;

public class CourtByFilterNotFoundException extends Exception {
    
    public static final String DESCRIPTION = "Ninguna pista encontrada para los filtros aplicados";

    public CourtByFilterNotFoundException() {
        super(DESCRIPTION);
    }

    public CourtByFilterNotFoundException(String detail) {
        super(DESCRIPTION + ": " + detail);
    }
}
