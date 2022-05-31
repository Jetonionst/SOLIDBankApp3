package com.example.SOLIDBankApp3.entity.account;

public class CheckingAccount extends AccountWithdraw {
    public CheckingAccount(String id, String clientID, double balance, long bankID) {
        super(AccountType.CHECKING, id, clientID, balance, true, bankID);
    }
}