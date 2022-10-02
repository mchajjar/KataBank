package com.example.bankkata.services;

import com.example.bankkata.exception.UserException.UserExistingException;
import com.example.bankkata.model.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    Optional<Account> getAccount(Integer accountId);
    Account createAccount(Account account) throws UserExistingException;
    Account updateAccount(Account account);
    void deleteAccount(Integer accountId);
    List<Account> getAccounts();


}
