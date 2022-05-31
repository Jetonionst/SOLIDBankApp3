package com.example.SOLIDBankApp3.dao;

import com.example.SOLIDBankApp3.entity.account.Account;
import com.example.SOLIDBankApp3.entity.transaction.Transaction;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, String> {
    @Query("SELECT * FROM Transaction")
    List<Transaction> getTransactions();

    @Modifying
    @Query("INSERT INTO Transaction(transaction_id) VALUES(:transaction)")
    void createNewTransaction(String transaction);
}
