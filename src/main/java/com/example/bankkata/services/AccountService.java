package com.example.bankkata.services;

import com.example.bankkata.exception.AmountRedExceededException;
import com.example.bankkata.model.Account;
import com.example.bankkata.repository.AccountrRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.bankkata.utils.AccountConstant.INITIALAMOUNT;
import static com.example.bankkata.utils.AccountConstant.redAmountmax;

@Service
public class AccountService implements IAccountService{


    private AccountrRepository accountrRepository;

    public AccountService ( AccountrRepository accountrRepository){
        this.accountrRepository = accountrRepository;
    }

    @Override
    public Account getAccount(Integer accountId) {
        return accountrRepository.getReferenceById(accountId);
    }

    @Override
    public Account createAccount(Account account) {
        account.setAmount(INITIALAMOUNT);
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




}
