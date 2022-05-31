package com.example.SOLIDBankApp2.service.internal;

import com.example.SOLIDBankApp2.dao.AccountDAO;
import com.example.SOLIDBankApp2.entity.account.Account;
import com.example.SOLIDBankApp2.service.AccountWithdrawService;
import org.springframework.stereotype.Service;

@Service
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    AccountDAO accountDAO;

    AccountWithdrawServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void withdraw(double amount, Account account) {
        //System.out.println(account.getAccountType());
        switch (account.getAccountType()) {
            case FIXED:
                System.out.println("This is FIXED account! Withdraw is not allowed!");
                return;
            case SAVING, CHECKING:
                Account newAccount = accountDAO.getClientAccount("1", String.valueOf(account.getId()));
                double balance = accountDAO.getClientAccount("1", String.valueOf(account.getId())).getBalance();
                if (balance >= amount) {
                    newAccount.setBalance(balance - amount);
                    accountDAO.updateNewAccount(account, newAccount);
                    System.out.println("The amount was withdrawn!");
                } else {
                    System.out.println("The amount exceeds the balance!");
                }
                break;
        }
    }
}