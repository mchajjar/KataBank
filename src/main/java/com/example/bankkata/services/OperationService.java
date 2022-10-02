package com.example.bankkata.services;

import com.example.bankkata.enums.OperationType;
import com.example.bankkata.exception.accountException.AccountNotFoundException;
import com.example.bankkata.exception.accountException.AmountRedExceededException;
import com.example.bankkata.model.Account;
import com.example.bankkata.model.Operation;
import com.example.bankkata.model.User;
import com.example.bankkata.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.example.bankkata.utils.AccountConstant.redAmountmax;
import static com.example.bankkata.utils.OperationConstant.REALEXECDATE;

@Service
public class OperationService implements IOperationService{

    @Autowired
    private AccountService accountService;

    @Autowired
    private OperationRepository OperationRepository;

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public Account savingOperation(Integer accountId, Double amount)  {
        Account currentAccount = accountService.getAccount(accountId).get();
        if ( currentAccount != null ){
            currentAccount.setAmount(currentAccount.getAmount()+ amount);
        }else{
            throw new AccountNotFoundException();
        }
        Operation ops = Operation.builder()
                .accountFrom(currentAccount)
                .amount(amount)
                .userFrom(currentAccount.getUserId())
                .type(OperationType.SAVING)
                .executionDate(LocalDate.now())
                .realDate(LocalDate.now())
                .build();
        addOperationToAccount(ops);
        return accountService.updateAccount(currentAccount);
    }

    @Override
    @Transactional
    public Account withdrawOperation(Integer accountId, Double amount) {
        Account currentAccount = accountService.getAccount(accountId).get();
        Double previsopnAmount = currentAccount.getAmount() - amount;
        if ((previsopnAmount ) < redAmountmax ) {
            throw  new AmountRedExceededException();
        }
        currentAccount.setAmount(previsopnAmount);
        Operation ops = Operation.builder()
                .accountFrom(currentAccount)
                .amount(amount)
                .userFrom(currentAccount.getUserId())
                .type(OperationType.WITHDRAW)
                .executionDate(LocalDate.now())
                .realDate(LocalDate.now())
                .build();
        addOperationToAccount(ops);
        return accountService.updateAccount(currentAccount);
    }

    @Override
    public Operation AddOperation(Operation ops) {
        return OperationRepository.save(ops);
    }

    @Override
    public List<Operation> getAllOps() {
        return OperationRepository.findAll();
    }

    private Operation addOperationToAccount(Operation operation){
        LocalDate dateNow = LocalDate.now();
        operation.setRealDate(dateNow);
        operation.setExecutionDate(dateNow.plusDays(REALEXECDATE));
        return OperationRepository.save(operation);

    }
}
