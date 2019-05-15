package com.reporting.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * custom error type.
 * is going to be thrown when the record not found on user query 
 * @author aykut
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String message){
        super(message);
    }
}