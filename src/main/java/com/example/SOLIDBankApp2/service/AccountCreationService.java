package com.example.SOLIDBankApp2.service;

import com.example.SOLIDBankApp2.entity.account.AccountType;
import org.springframework.stereotype.Service;

@Service
public interface AccountCreationService {
    default void create(AccountType accountType, long bankID, String clientID, long accountID) {
    }
}
