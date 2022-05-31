package com.example.SOLIDBankApp3.service.internal;

import com.example.SOLIDBankApp3.dao.AccountDAO;
import com.example.SOLIDBankApp3.dao.AccountRepository;
import com.example.SOLIDBankApp3.dao.TransactionRepository;
import com.example.SOLIDBankApp3.entity.account.Account;
import com.example.SOLIDBankApp3.service.AccountWithdrawService;
import org.springframework.stereotype.Service;

@Service
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    //AccountDAO accountDAO;

    AccountRepository accountRepository;
    TransactionRepository transactionRepository;

    //AccountWithdrawServiceImpl(AccountDAO accountDAO) {
    //    this.accountDAO = accountDAO;
    //}

    AccountWithdrawServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository){
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void withdraw(double amount, Account account) {
        //System.out.println(account.getAccountType());
        switch (account.getAccountType()) {
            case FIXED:
                System.out.println("This is FIXED account! Withdraw is not allowed!");
                return;
            case SAVING, CHECKING:
                //Account newAccount = accountDAO.getClientAccount("1", String.valueOf(account.getId()));
                //double balance = accountDAO.getClientAccount("1", String.valueOf(account.getId())).getBalance();
                double balance = account.getBalance();
                if (balance >= amount) {
                    //newAccount.setBalance(balance - amount);
                    account.setBalance(balance - amount);
                    //accountDAO.updateNewAccount(account, newAccount);
                    accountRepository.updateNewAccount(account.getId(), account.getBalance());
                    transactionRepository.createNewTransaction("Deposit transaction: " + "account - " + account.getId() + ", balance - " + account.getBalance());
                    System.out.println("The amount was withdrawn!");
                } else {
                    System.out.println("The amount exceeds the balance!");
                }
                break;
        }
    }
}