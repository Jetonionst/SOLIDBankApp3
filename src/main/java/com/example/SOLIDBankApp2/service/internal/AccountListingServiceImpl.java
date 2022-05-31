package com.example.SOLIDBankApp2.service.internal;

import com.example.SOLIDBankApp2.dao.AccountDAO;
import com.example.SOLIDBankApp2.entity.account.Account;
import com.example.SOLIDBankApp2.entity.account.AccountType;
import com.example.SOLIDBankApp2.entity.account.AccountWithdraw;
import com.example.SOLIDBankApp2.service.AccountListingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountListingServiceImpl implements AccountListingService {
    private final AccountDAO accountDAO;

    public AccountListingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return accountDAO.getClientAccount(clientID, accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return accountDAO.getClientWithdrawAccount(clientID, accountID);
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountDAO.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return getClientAccountsByType(clientID, accountType);
    }
}