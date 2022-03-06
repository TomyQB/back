package com.appuntate.back.exceptionHandler.exceptions.forbidden;

public class CourtAlreadyReservedForbiddenException extends Exception {
    
    public static final String DESCRIPTION = "Ya existe una reserva para la pista con id";

    public CourtAlreadyReservedForbiddenException() {
        super(DESCRIPTION);
    }

    public CourtAlreadyReservedForbiddenException(long detail) {
        super(DESCRIPTION + ": " + detail + " para esa fecha y hora ");
    }
}
