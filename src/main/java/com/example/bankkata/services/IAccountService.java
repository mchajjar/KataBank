package com.example.bankkata.services;

import com.example.bankkata.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IAccountService {
    Account getAccount(Integer accountId);
    Account addAccount(Account account);
    Account updateAccount(Account account);
    void deleteAccount(Integer accountId);
    List<Account> getAccounts();

    Account addSaving(Integer accountId , Double amount ) throws Exception;
    Account withdrawSaving(Integer accountId , Double amount );

}
