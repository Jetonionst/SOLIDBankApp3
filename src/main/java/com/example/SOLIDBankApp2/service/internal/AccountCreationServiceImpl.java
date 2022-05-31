package com.example.SOLIDBankApp2.service.internal;

import com.example.SOLIDBankApp2.dao.AccountDAO;
import com.example.SOLIDBankApp2.entity.account.*;
import com.example.SOLIDBankApp2.service.AccountCreationService;
import org.springframework.stereotype.Service;

@Service
class AccountCreationServiceImpl implements AccountCreationService {
    private final AccountDAO accountDAO;

    AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        String accountNumber = String.format("%03d%06d", 1, accountID);
        Account account = null;
        switch (accountType) {
            case FIXED:
                account = new FixedAccount(accountNumber, clientID, 0, bankID);
                break;
            case SAVING:
                account = new SavingAccount(accountNumber, clientID, 0, bankID);
                break;
            case CHECKING:
                account = new CheckingAccount(accountNumber, clientID, 0, bankID);
                break;
        }
        accountDAO.createNewAccount(account);
        System.out.println("New Account was created!");
    }
}