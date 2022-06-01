package com.example.SOLIDBankApp3.controller;

import com.example.SOLIDBankApp3.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    TransactionService transactionService;

    @GetMapping("/all")
    public List<String> getClientAccounts(@RequestParam String clientID){
        return transactionService.getClientTransactions(clientID);
    }
}
