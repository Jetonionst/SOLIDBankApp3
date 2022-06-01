package com.example.SOLIDBankApp3.service.internal;

import com.example.SOLIDBankApp3.dao.TransactionRepository;
import com.example.SOLIDBankApp3.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<String> getClientTransactions(String clientID) {
        return transactionRepository.getClientTransactions();
    }

}
