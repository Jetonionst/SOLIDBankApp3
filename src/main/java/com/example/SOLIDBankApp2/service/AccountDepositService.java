package com.example.SOLIDBankApp2.service;

import com.example.SOLIDBankApp2.entity.account.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountDepositService {
    void deposit(double amount, Account account);
}
