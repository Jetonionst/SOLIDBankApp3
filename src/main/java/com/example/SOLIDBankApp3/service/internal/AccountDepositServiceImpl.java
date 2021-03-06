package com.example.SOLIDBankApp3.service.internal;

import com.example.SOLIDBankApp3.dao.AccountDAO;
import com.example.SOLIDBankApp3.dao.AccountRepository;
import com.example.SOLIDBankApp3.dao.TransactionRepository;
import com.example.SOLIDBankApp3.entity.account.Account;
import com.example.SOLIDBankApp3.entity.transaction.Transaction;
import com.example.SOLIDBankApp3.service.AccountDepositService;
import org.springframework.stereotype.Service;

@Service
public class AccountDepositServiceImpl implements AccountDepositService {
    //AccountDAO accountDAO;

    AccountRepository accountRepository;
    TransactionRepository transactionRepository;

    //AccountDepositServiceImpl(AccountDAO accountDAO) {
    //    this.accountDAO = accountDAO;
    //}

    AccountDepositServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository){
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void deposit(double amount, String accountID) {
        //Account newAccount = accountDAO.getClientAccount("1", String.valueOf(account.getId()));
        //double balance = accountDAO.getClientAccount("1", String.valueOf(account.getId())).getBalance();

        Account account = accountRepository.getClientAccount("1", accountID);
        account.setBalance(account.getBalance() + amount);
        accountRepository.updateNewAccount(account.getId(), account.getBalance());
        Transaction transaction = new Transaction("Deposit transaction: " + "account - " + account.getId() + ", amount - " + amount);
        transactionRepository.createNewTransaction(transaction.getTransaction());
        System.out.println("The amount was deposited!");
    }
}