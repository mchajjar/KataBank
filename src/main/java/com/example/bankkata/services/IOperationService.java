package com.example.bankkata.services;

import com.example.bankkata.exception.accountException.AmountRedExceededException;
import com.example.bankkata.model.Account;

public interface IOperationService {

    Account savingOperation(Integer accountId , Double amount ) throws Exception;
    Account withdrawOperation(Integer accountId , Double amount ) throws AmountRedExceededException;
}
