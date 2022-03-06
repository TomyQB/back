package com.appuntate.back.exceptionHandler.exceptions.forbidden;

public class UpdatePasswordForbiddenException extends Exception {
    
    public static final String DESCRIPTION = "Error al introducir la contraseña";

    public UpdatePasswordForbiddenException() {
        super(DESCRIPTION);
    }

    public UpdatePasswordForbiddenException(String detail) {
        super(DESCRIPTION + ": " + detail);
    }
}
