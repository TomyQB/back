package com.appuntate.back.exceptionHandler.exceptions.forbidden;

public class NotAvailableReservationForbiddenException extends Exception {
    
    public static final String DESCRIPTION = "No se han encontrado pistas disponibles para hacer la reserva el día";

    public NotAvailableReservationForbiddenException() {
        super(DESCRIPTION);
    }

    public NotAvailableReservationForbiddenException(String detail, String detail2) {
        super(DESCRIPTION + " " + detail + " a las " + detail2);
    }
}
