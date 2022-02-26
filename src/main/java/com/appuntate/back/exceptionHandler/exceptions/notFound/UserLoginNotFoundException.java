package com.appuntate.back.exceptionHandler.exceptions.notFound;

public class UserLoginNotFoundException extends Exception {
    
    public static final String DESCRIPTION = "Error al introducir las credenciales";

    public UserLoginNotFoundException() {
        super(DESCRIPTION);
    }

    public UserLoginNotFoundException(String detail) {
        super(DESCRIPTION + ": " + detail);
    }
}
