package com.example.bankkata.exception;

import com.example.bankkata.model.CustomError;

public class CustomException extends RuntimeException{

    protected CustomError customError;

    public CustomException(CustomError customError){
        super();
        this.customError = customError;
    }
}
