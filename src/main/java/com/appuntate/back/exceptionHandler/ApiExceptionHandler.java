package com.appuntate.back.exceptionHandler;

import java.nio.file.AccessDeniedException;

import javax.servlet.http.HttpServletRequest;

import com.appuntate.back.exceptionHandler.exceptions.badRequest.UserAlreadyRegisterException;
import com.appuntate.back.exceptionHandler.exceptions.badRequest.UserRegisterException;
import com.appuntate.back.exceptionHandler.exceptions.badRequest.UserUpdateException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.ReservationIdNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.ReservationUserNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.UserIdNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.UserLoginNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UserIdNotFoundException.class, ReservationIdNotFoundException.class, UserLoginNotFoundException.class, ReservationUserNotFoundException.class})
    @ResponseBody
    public ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception) {
        return new ErrorMessage(exception, request.getRequestURI());
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({UserUpdateException.class, UserRegisterException.class, UserAlreadyRegisterException.class})
    @ResponseBody
    public ErrorMessage badRequest(HttpServletRequest request, Exception exception) {
        return new ErrorMessage(exception, "");
    }
    
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({AccessDeniedException.class})
    @ResponseBody
    public ErrorMessage forbiddenRequest(HttpServletRequest request, Exception exception) {
        return new ErrorMessage(exception, "");
    }
    
}
