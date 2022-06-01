package com.example.SOLIDBankApp3.controller;

import com.example.SOLIDBankApp3.entity.account.Account;
import com.example.SOLIDBankApp3.service.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {
    private BankCore bankCore;
    private AccountListingService accountListingService;
    private AccountWithdrawService accountWithdrawService;
    private AccountDepositService accountDepositService;
    private AccountDeletingService accountDeletingService;


    @GetMapping("/all")
    public List<Account> getClientAccounts(@RequestParam String clientID){
        return accountListingService.getClientAccounts(clientID);
    }

    @GetMapping("/{clientID}")
    public Account getClientAccount(@PathVariable String clientID, @RequestParam String accountID) {
        return accountListingService.getClientAccount(clientID, accountID);
    }

    @PostMapping
    public void createNewAccount(@RequestParam String accountType, @RequestParam String clientID){
        bankCore.createNewAccount(accountType, clientID);
    }

    @PostMapping("/deposit")
    public void deposit(@RequestParam double amount, @RequestParam String accountID){
        accountDepositService.deposit(amount, accountID);
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestParam double amount, @RequestParam String accountID){
        accountWithdrawService.withdraw(amount, accountID);
    }

    @DeleteMapping
    public void deleteAccount(@RequestParam String clientID, @RequestParam String accountID){
        accountDeletingService.delete(clientID, accountID);
    }
}
