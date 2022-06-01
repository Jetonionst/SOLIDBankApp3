package com.example.SOLIDBankApp3.service;

import com.example.SOLIDBankApp3.entity.account.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {
    List<String> getClientTransactions(String clientID);

}
