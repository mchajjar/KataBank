package com.example.bankkata.exception.UserException;

import com.example.bankkata.exception.CustomException;
import com.example.bankkata.model.CustomError;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends CustomException {

    private static final String CAUSE= "The user you are trying to find doesn't exists";
    private static final int code = HttpStatus.NOT_FOUND.value();
    private static final long serialVersionUID = 2;

    public UserNotFoundException(String message){
       super(new CustomError(code,message,CAUSE));
    }
    public UserNotFoundException(){
        super(new CustomError(code,CAUSE,CAUSE));
    }


}
