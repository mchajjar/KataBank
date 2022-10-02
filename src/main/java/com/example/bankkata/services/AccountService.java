package com.example.bankkata.services;

import com.example.bankkata.exception.UserException.UserExistingException;
import com.example.bankkata.exception.accountException.AccountExistingException;
import com.example.bankkata.exception.accountException.AccountNotFoundException;
import com.example.bankkata.exception.accountException.InvalideDataAccountException;
import com.example.bankkata.model.Account;
import com.example.bankkata.repository.AccountrRepository;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.example.bankkata.utils.AccountConstant.INITIALAMOUNT;

@Service
public class AccountService implements IAccountService{


    private AccountrRepository accountrRepository;

    public AccountService ( AccountrRepository accountrRepository){
        this.accountrRepository = accountrRepository;
    }

    private boolean isAccountFound(Integer accountId){
        boolean exists = false;
        try{
            accountrRepository.findById(accountId).get();
        }catch (NoSuchElementException e){
            return  exists;
        }
        return !exists;
    }

    @Override
    public Optional<Account> getAccount(Integer accountId)  {
        return accountrRepository.findById(accountId);
    }

    @Override
    public Account createAccount(Account account) throws UserExistingException {
        try {
            if (isAccountFound(account.getId())){
                throw new AccountExistingException("The account= "+account.getId() + "already exists"  );
            }
            account.setAmount(INITIALAMOUNT);
            return accountrRepository.save(account);
        }catch (InvalidDataAccessApiUsageException e){
            throw new InvalideDataAccountException(e.getMessage());
        }

    }

    @Override
    public Account updateAccount(Account account) {
        try {
            if (!isAccountFound(account.getId())){
                throw new AccountNotFoundException("The account= "+account.getId() + "does not  exists"  );
            }
            account.setModificationDate(LocalDate.now());
            return accountrRepository.save(account);
        }catch (InvalidDataAccessApiUsageException e){
            throw new InvalideDataAccountException(e.getMessage());
        }
    }


    @Override
    public void deleteAccount(Integer accountId) {
        try {
            if (!isAccountFound(accountId)){
                throw new AccountNotFoundException("The account= "+accountId + "does not  exists"  );
            }
            accountrRepository.deleteById(accountId);
        }catch (InvalidDataAccessApiUsageException e){
            throw new InvalideDataAccountException(e.getMessage());
        }
    }

    @Override
    public List<Account> getAccounts() {
        return accountrRepository.findAll();
    }


}
