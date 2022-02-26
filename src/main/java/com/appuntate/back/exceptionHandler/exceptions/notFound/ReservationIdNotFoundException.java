package com.appuntate.back.exceptionHandler.exceptions.notFound;

public class ReservationIdNotFoundException extends Exception {
    
    public static final String DESCRIPTION = "Reserva no encontrada, id";

    public ReservationIdNotFoundException() {
        super(DESCRIPTION);
    }

    public ReservationIdNotFoundException(String detail) {
        super(DESCRIPTION + ": " + detail);
    }
}
