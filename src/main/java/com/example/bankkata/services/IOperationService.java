package com.example.bankkata.services;

import com.example.bankkata.exception.AmountRedExceededException;
import com.example.bankkata.model.Account;
import com.example.bankkata.model.Operation;

public interface IOperationService {

    Account savingOperation(Integer accountId , Double amount ) throws Exception;
    Account withdrawOperation(Integer accountId , Double amount ) throws AmountRedExceededException;
}
