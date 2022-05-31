package com.example.SOLIDBankApp3.service.internal;

import com.example.SOLIDBankApp3.dao.AccountDAO;
import com.example.SOLIDBankApp3.dao.AccountRepository;
import com.example.SOLIDBankApp3.dao.TransactionRepository;
import com.example.SOLIDBankApp3.entity.account.Account;
import com.example.SOLIDBankApp3.entity.account.AccountType;
import com.example.SOLIDBankApp3.entity.account.AccountWithdraw;
import com.example.SOLIDBankApp3.entity.transaction.Transaction;
import com.example.SOLIDBankApp3.service.AccountListingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountListingServiceImpl implements AccountListingService {
    //private final AccountDAO accountDAO;

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    //public AccountListingServiceImpl(AccountDAO accountDAO) {
    //    this.accountDAO = accountDAO;
    //}

    public AccountListingServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository){
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }
    @Override
    public Account getClientAccount(String clientID, String accountID) {
        //return accountDAO.getClientAccount(clientID, accountID);
        return accountRepository.getClientAccount(clientID, accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        //return accountDAO.getClientWithdrawAccount(clientID, accountID);
        return accountRepository.getClientWithdrawAccount(clientID, accountID);
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        //return accountDAO.getClientAccounts(clientID);
        return accountRepository.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountRepository.getClientAccountsByType(clientID, accountType);
    }

    @Override
    public List<Transaction> getTransactions(){
        return transactionRepository.getTransactions();
    }
}