package com.example.SOLIDBankApp2.entity.account;

public class FixedAccount extends AccountDeposit {
    public FixedAccount(String id, String clientID, double balance, long bankID) {
        super(AccountType.FIXED, id, clientID, balance, false, bankID);
    }
}