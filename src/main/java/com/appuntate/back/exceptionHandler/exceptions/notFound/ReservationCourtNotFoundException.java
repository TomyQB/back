package com.appuntate.back.exceptionHandler.exceptions.notFound;

public class ReservationCourtNotFoundException extends Exception {
    
    public static final String DESCRIPTION = "No se han encontrado reservas para el centro con id";

    public ReservationCourtNotFoundException() {
        super(DESCRIPTION);
    }

    public ReservationCourtNotFoundException(String detail) {
        super(DESCRIPTION + ": " + detail);
    }
}
