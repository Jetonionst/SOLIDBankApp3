package com.example.SOLIDBankApp3.service;

import com.example.SOLIDBankApp3.entity.account.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountWithdrawService {
    void withdraw(double amount, Account account);
}