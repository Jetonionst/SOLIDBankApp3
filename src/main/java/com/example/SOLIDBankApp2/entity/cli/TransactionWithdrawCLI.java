package com.example.SOLIDBankApp2.entity.cli;

import com.example.SOLIDBankApp2.entity.account.Account;
import com.example.SOLIDBankApp2.entity.transaction.TransactionWithdraw;
import com.example.SOLIDBankApp2.entity.ui.WithdrawDepositOperationCLIUI;
import com.example.SOLIDBankApp2.service.AccountListingService;
import org.springframework.stereotype.Component;

@Component
public class TransactionWithdrawCLI{
    TransactionWithdraw transactionWithdraw;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListingService;

    public TransactionWithdrawCLI(TransactionWithdraw transactionWithdraw, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListingService){
        this.transactionWithdraw=transactionWithdraw;
        this.withdrawDepositOperationCLIUI=withdrawDepositOperationCLIUI;
        this.accountListingService=accountListingService;
    }
    public void withdrawMoney(String clientID){
        System.out.println("Enter your accountID: ");
        Account account = accountListingService.getClientAccount(clientID, withdrawDepositOperationCLIUI.requestClientAccountNumber());
        if(account==null){
            System.out.println("There is no such accountID!");
            return;
        }
        System.out.println("Enter amount to withdraw: ");
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        transactionWithdraw.execute(account, amount);
    };
}