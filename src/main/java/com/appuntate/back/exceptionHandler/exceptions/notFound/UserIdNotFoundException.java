package com.appuntate.back.exceptionHandler.exceptions.notFound;

public class UserIdNotFoundException extends Exception {
    
    public static final String DESCRIPTION = "Usuario no encontrado, id";

    public UserIdNotFoundException() {
        super(DESCRIPTION);
    }

    public UserIdNotFoundException(long detail) {
        super(DESCRIPTION + ": " + detail);
    }
    
}
