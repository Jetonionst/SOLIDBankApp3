package com.example.SOLIDBankApp2.dao;

import com.example.SOLIDBankApp2.entity.account.Account;
import com.example.SOLIDBankApp2.entity.account.AccountType;
import com.example.SOLIDBankApp2.entity.account.AccountWithdraw;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDAO{
    List<Account> getClientAccounts(String clientID);
    void createNewAccount(Account account);
    void updateNewAccount(Account accountWithdraw, Account account);
    Account getClientAccount(String clientID, String accountID);
    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
}
