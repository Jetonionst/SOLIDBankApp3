package com.example.SOLIDBankApp2.dao;

import com.example.SOLIDBankApp2.entity.transaction.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDAO {
    List<Transaction> getTransactions();
    void addTransaction(Transaction transaction);
}