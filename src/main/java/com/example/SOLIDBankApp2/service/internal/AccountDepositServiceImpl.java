package com.example.SOLIDBankApp2.service.internal;

import com.example.SOLIDBankApp2.dao.AccountDAO;
import com.example.SOLIDBankApp2.entity.account.Account;
import com.example.SOLIDBankApp2.service.AccountDepositService;
import org.springframework.stereotype.Service;

@Service
public class AccountDepositServiceImpl implements AccountDepositService {
    AccountDAO accountDAO;

    AccountDepositServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void deposit(double amount, Account account) {
        Account newAccount = accountDAO.getClientAccount("1", String.valueOf(account.getId()));
        double balance = accountDAO.getClientAccount("1", String.valueOf(account.getId())).getBalance();
        newAccount.setBalance(balance + amount);
        accountDAO.updateNewAccount(account, newAccount);
        System.out.println("The amount was deposited!");
    }
}