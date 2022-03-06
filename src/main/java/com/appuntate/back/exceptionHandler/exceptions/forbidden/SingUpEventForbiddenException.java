package com.appuntate.back.exceptionHandler.exceptions.forbidden;

public class SingUpEventForbiddenException extends Exception {
    
    public static final String DESCRIPTION = "El usuario ya se ha registrado en este evento";

    public SingUpEventForbiddenException() {
        super(DESCRIPTION);
    }

    public SingUpEventForbiddenException(String detail) {
        super(DESCRIPTION + ": " + detail);
    }
}
