package com.example.bankkata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AmountRedExceededException extends Exception{

    private static final long serialVersionUID = 2;
    public AmountRedExceededException(String message){
        super(message);
    }
}
