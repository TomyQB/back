package com.appuntate.back.exceptionHandler.exceptions.notFound;

public class ReservationUserNotFoundException extends Exception {
    
    public static final String DESCRIPTION = "No se han encontrado reservas para el usuario con id";

    public ReservationUserNotFoundException() {
        super(DESCRIPTION);
    }

    public ReservationUserNotFoundException(String detail) {
        super(DESCRIPTION + ": " + detail);
    }
}
