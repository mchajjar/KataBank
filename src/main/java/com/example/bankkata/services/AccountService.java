package com.example.bankkata.services;

import com.example.bankkata.exception.AmountRedExceededException;
import com.example.bankkata.model.Account;
import com.example.bankkata.repository.AccountrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService implements IAccountService{

    Double redAmountmax = 1000.;

    private AccountrRepository accountrRepository;

    public AccountService ( AccountrRepository accountrRepository){
        this.accountrRepository = accountrRepository;
    }

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
    public Account withdrawSaving(Integer accountId, Double amount)
            throws AmountRedExceededException {
        Account currentAccount = getAccount(accountId);
        Double previsopnAmount = currentAccount.getAmount() - amount;
        if ((previsopnAmount - amount ) > redAmountmax ) {
            throw  new AmountRedExceededException("");
        }
        currentAccount.setAmount(previsopnAmount);
        return updateAccount(currentAccount);
    }


}
