package com.appuntate.back.exceptionHandler.exceptions.badRequest;

public class UserUpdateException extends Exception {
    
    public static final String DESCRIPTION = "Error al actualizar la información del usuario";

    public UserUpdateException() {
        super(DESCRIPTION);
    }

    public UserUpdateException(String detail) {
        super(DESCRIPTION + ": " + detail);
    }
}
