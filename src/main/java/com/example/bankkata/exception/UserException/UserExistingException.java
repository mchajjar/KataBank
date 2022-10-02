package com.example.bankkata.exception.UserException;

import com.example.bankkata.exception.CustomException;
import com.example.bankkata.model.CustomError;
import org.springframework.http.HttpStatus;

public class UserExistingException extends CustomException {

    private static final String CAUSE= "The user your are trying to create already exists";
    private static final long serialVersionUID = 2;
    private static final int code = HttpStatus.NOT_FOUND.value();

    public UserExistingException(String message){
        super(new CustomError(code,message,CAUSE));
    }
    public UserExistingException(){
        super(new CustomError(code,CAUSE,CAUSE));
    }


}
