package com.example.bankkata.services;

import com.example.bankkata.exception.AmountRedExceededException;
import com.example.bankkata.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IAccountService {
    Account getAccount(Integer accountId);
    Account createAccount(Account account);
    Account updateAccount(Account account);
    void deleteAccount(Integer accountId);
    List<Account> getAccounts();


}
