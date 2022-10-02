package com.example.bankkata.exception;

import com.example.bankkata.exception.UserException.InvalideDataUserException;
import com.example.bankkata.exception.UserException.UserExistingException;
import com.example.bankkata.exception.UserException.UserNotFoundException;
import com.example.bankkata.exception.accountException.AccountNotFoundException;
import com.example.bankkata.exception.accountException.AmountRedExceededException;
import com.example.bankkata.exception.accountException.InvalideDataAccountException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({CustomException.class,
            UserExistingException.class,
            UserNotFoundException.class,
            AmountRedExceededException.class,
            AccountNotFoundException.class,
            InvalideDataAccountException.class,
            InvalideDataUserException.class
    })
    public ResponseEntity handleCustomException(CustomException e) {
        return ResponseEntity.status(e.customError.getCode())
                .body(e.customError.getMessage());
    }

}
