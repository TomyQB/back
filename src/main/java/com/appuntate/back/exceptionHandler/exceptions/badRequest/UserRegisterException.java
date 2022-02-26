package com.appuntate.back.exceptionHandler.exceptions.badRequest;

public class UserRegisterException extends Exception {
    
    public static final String DESCRIPTION = "Error al registrar el usuario";

    public UserRegisterException() {
        super(DESCRIPTION);
    }

    public UserRegisterException(String detail) {
        super(DESCRIPTION + ": " + detail);
    }
}
