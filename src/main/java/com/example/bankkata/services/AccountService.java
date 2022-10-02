package com.example.bankkata.services;

import com.example.bankkata.exception.UserException.UserExistingException;
import com.example.bankkata.exception.UserException.UserNotFoundException;
import com.example.bankkata.exception.accountException.AccountExistingException;
import com.example.bankkata.exception.accountException.AccountNotFoundException;
import com.example.bankkata.model.Account;
import com.example.bankkata.repository.AccountrRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.example.bankkata.utils.AccountConstant.INITIALAMOUNT;

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
    public Account createAccount(Account account) throws UserExistingException {
        //check if user already exists
        if(Objects.nonNull(getAccount(account.getId()))){
            throw new AccountExistingException();
        }
        account.setAmount(INITIALAMOUNT);
        return accountrRepository.save(account);
    }

    @Override
    public Account updateAccount(Account account) {
        if(Objects.isNull(getAccount(account.getId()))){
            throw new AccountNotFoundException("The user : CIN = "+account.getId() + "doens't exists"  );
        }
        return accountrRepository.save(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        if(Objects.isNull(getAccount(accountId))){
            throw new AccountNotFoundException("The user : CIN = "+accountId + "doens't exists"  );
        }
        accountrRepository.deleteById(accountId);
    }

    @Override
    public List<Account> getAccounts() {
        return accountrRepository.findAll();
    }




}
