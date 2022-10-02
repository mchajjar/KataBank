package com.example.bankkata.services;

import com.example.bankkata.exception.accountException.AmountRedExceededException;
import com.example.bankkata.model.Account;
import com.example.bankkata.model.Operation;
import com.example.bankkata.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static com.example.bankkata.utils.AccountConstant.redAmountmax;
import static com.example.bankkata.utils.OperationConstant.REALEXECDATE;

@Service
public class OperationService implements IOperationService{

    @Autowired
    private AccountService accountService;

    @Autowired
    private OperationRepository OperationRepository;

    @Override
    public Account savingOperation(Integer accountId, Double amount) throws Exception {
        Account currentAccount = accountService.getAccount(accountId).get();
        if ( currentAccount != null ){
            currentAccount.setAmount(currentAccount.getAmount()+ amount);
        }else{
            throw new Exception(":(");
        }
        return accountService.updateAccount(currentAccount);
    }

    @Override
    public Account withdrawOperation(Integer accountId, Double amount)
            throws AmountRedExceededException {
        Account currentAccount = accountService.getAccount(accountId).get();
        Double previsopnAmount = currentAccount.getAmount() - amount;
        if ((previsopnAmount - amount ) > redAmountmax ) {
            throw  new AmountRedExceededException();
        }
        currentAccount.setAmount(previsopnAmount);
        return accountService.updateAccount(currentAccount);
    }

    private Operation addOperationToAccount(Operation operation){
        LocalDate dateNow = LocalDate.now();
        operation.setRealDate(dateNow);
        operation.setExecutionDate(dateNow.plusDays(REALEXECDATE));
        return OperationRepository.save(operation);

    }
}
