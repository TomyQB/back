package com.appuntate.back.exceptionHandler.exceptions.badRequest;

public class UserAlreadyRegisterException extends Exception {
    
    public static final String DESCRIPTION = "El email introducido ya está en uso";

    public UserAlreadyRegisterException() {
        super(DESCRIPTION);
    }

    public UserAlreadyRegisterException(String detail) {
        super(DESCRIPTION + ": " + detail);
    }
}
