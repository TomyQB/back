package com.appuntate.back.exceptionHandler.exceptions.forbidden;

public class UserAlreadyRegisterException extends Exception {
    
    public static final String DESCRIPTION = "El email o el nombre de usuario introducidos ya están en uso";

    public UserAlreadyRegisterException() {
        super(DESCRIPTION);
    }

    public UserAlreadyRegisterException(String email, String userName) {
        super(DESCRIPTION + ": email: " + email + ", userName: userName");
    }
}
