package com.example.bankkata.controller;

import com.example.bankkata.exception.AmountRedExceededException;
import com.example.bankkata.model.Account;
import com.example.bankkata.services.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/katabank/ops")
public class OperationController {


    @Autowired
    IOperationService iOperationService;

    @PostMapping("/addsaving")
    Account addSaving(@PathVariable Integer accountId , @PathVariable Double amount )
            throws Exception{
        return iOperationService.savingOperation(accountId,amount);
    }

    @PostMapping("/withdraw")
    Account withdrawSaving(@PathVariable Integer accountId , @PathVariable Double amount )
            throws AmountRedExceededException {
        return iOperationService.withdrawOperation(accountId,amount);
    }
}
