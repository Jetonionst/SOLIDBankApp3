package com.example.SOLIDBankApp2.entity.transaction;

import com.example.SOLIDBankApp2.dao.TransactionDAO;
import com.example.SOLIDBankApp2.entity.account.Account;
import com.example.SOLIDBankApp2.service.AccountWithdrawService;
import org.springframework.stereotype.Component;

@Component
public class TransactionWithdraw {
    AccountWithdrawService accountWithdrawService;
    TransactionDAO transactionDAO;

    TransactionWithdraw(AccountWithdrawService accountWithdrawService, TransactionDAO transactionDAO){
        this.accountWithdrawService=accountWithdrawService;
        this.transactionDAO=transactionDAO;
    }
    public void execute(Account account, double amount){
        accountWithdrawService.withdraw(amount, account);
    }
}