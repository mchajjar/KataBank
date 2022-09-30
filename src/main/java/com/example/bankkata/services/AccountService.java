package com.example.bankkata.services;

import com.example.bankkata.model.Account;
import com.example.bankkata.repository.AccountrRepository;

import java.util.List;

public class AccountService implements IAccountService{

    AccountrRepository accountrRepository;

    @Override
    public Account getAccount(Integer accountId) {
        return accountrRepository.getReferenceById(accountId);
    }

    @Override
    public Account addAccount(Account account) {
        return accountrRepository.save(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return accountrRepository.save(account);
    }

    @Override
    public void deleteAccount(Integer account) {
        accountrRepository.deleteById(account);
    }

    @Override
    public List<Account> getAccounts() {
        return accountrRepository.findAll();
    }

    @Override
    public Account addSaving(Integer accountId, Double amount) throws Exception {
        Account currentAccount = getAccount(accountId);
        if ( currentAccount != null ){
            currentAccount.setAmount(currentAccount.getAmount()+ amount);
        }else{
            throw new Exception(":(");
        }
        return updateAccount(currentAccount);
    }

    @Override
    public Account withdrawSaving(Integer accountId, Double amount) {
        return null;
    }


}
