package com.example.SOLIDBankApp3.entity.cli;

import com.example.SOLIDBankApp3.service.TransactionService;
import org.springframework.stereotype.Component;

@Component
public class TransactionBasicCLI {

    TransactionService transactionService;

    public TransactionBasicCLI(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void getClientTransactions(String clientID){
        System.out.println(transactionService.getClientTransactions(clientID));
    }
}
