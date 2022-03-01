package com.appuntate.back.exceptionHandler.exceptions.notFound;

public class CenterWithAvailableCourtsNotFoundException extends Exception {
    
    public static final String DESCRIPTION = "No se han encontrado centros con pistas disponibles";

    public CenterWithAvailableCourtsNotFoundException() {
        super(DESCRIPTION);
    }

    public CenterWithAvailableCourtsNotFoundException(String detail) {
        super(DESCRIPTION + ": " + detail);
    }
}
