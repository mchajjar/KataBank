package com.example.bankkata.exception.UserException;

import com.example.bankkata.exception.CustomException;
import com.example.bankkata.model.CustomError;
import org.springframework.http.HttpStatus;

public class InvalideDataUserException extends CustomException {

    private static final String CAUSE= "ERROR DATA";
    private static final long serialVersionUID = 2;
    private static final int code = HttpStatus.NOT_FOUND.value();

    public InvalideDataUserException(String message){
        super(new CustomError(code,message,CAUSE));
    }
    public InvalideDataUserException(){
        super(new CustomError(code,CAUSE,CAUSE));
    }

}
