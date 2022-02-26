package com.appuntate.back.exceptionHandler.exceptions.notFound;

public class CentersByFilterNotFoundException extends Exception {
    
    public static final String DESCRIPTION = "Ningún centro encontrado para los filtros aplicados";

    public CentersByFilterNotFoundException() {
        super(DESCRIPTION);
    }

    public CentersByFilterNotFoundException(String detail) {
        super(DESCRIPTION + ": " + detail);
    }
}
