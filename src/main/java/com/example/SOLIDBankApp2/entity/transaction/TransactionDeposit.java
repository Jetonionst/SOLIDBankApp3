package com.example.SOLIDBankApp2.entity.transaction;

import com.example.SOLIDBankApp2.dao.TransactionDAO;
import com.example.SOLIDBankApp2.entity.account.Account;
import com.example.SOLIDBankApp2.service.AccountDepositService;
import org.springframework.stereotype.Component;

@Component
public class TransactionDeposit {
    AccountDepositService accountDepositService;
    TransactionDAO transactionDAO;

    TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO){
        this.accountDepositService=accountDepositService;
        this.transactionDAO=transactionDAO;
    }
    public void execute(Account account, double amount){
        accountDepositService.deposit(amount, account);
    }
}