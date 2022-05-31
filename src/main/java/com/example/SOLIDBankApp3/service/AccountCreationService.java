package com.example.SOLIDBankApp3.service;

import com.example.SOLIDBankApp3.entity.account.AccountType;
import org.springframework.stereotype.Service;

@Service
public interface AccountCreationService {
    default void create(AccountType accountType, long bankID, String clientID, long accountID) {
    }
}
