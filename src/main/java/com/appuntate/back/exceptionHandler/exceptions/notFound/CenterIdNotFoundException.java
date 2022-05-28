package com.appuntate.back.exceptionHandler.exceptions.notFound;

public class CenterIdNotFoundException extends Exception {
    
    public static final String DESCRIPTION = "Centro no encontrado, id";

    public CenterIdNotFoundException() {
        super(DESCRIPTION);
    }

    public CenterIdNotFoundException(long detail) {
        super(DESCRIPTION + ": " + detail);
    }
    
}
