package com.example.bankkata.controller;

import com.example.bankkata.model.Account;
import com.example.bankkata.model.Operation;
import com.example.bankkata.services.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/katabank/ops")
public class OperationController {


    @Autowired
    IOperationService iOperationService;

    @PostMapping("/addsaving/{accountId}/{amount}")
    Account addSaving(@PathVariable Integer accountId , @PathVariable Double amount )
            throws Exception{
        return iOperationService.savingOperation(accountId,amount);
    }

    @PostMapping("/withdraw/{accountId}/{amount}")
    Account withdrawSaving(@PathVariable Integer accountId , @PathVariable Double amount )
            throws Exception {
        return iOperationService.withdrawOperation(accountId,amount);
    }

    @GetMapping("/all")
    List<Operation> getAllOps() {
        return iOperationService.getAllOps();
    }

    @GetMapping("/all/{accountId}")
    List<Operation> getopsby(@PathVariable Integer accountId) {
        return iOperationService.getAllOpsByAccountId(accountId);
    }


}
