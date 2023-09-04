package ru.sberbank.jd.service;

import ru.sberbank.jd.entity.BankAccount;

import java.util.Optional;

public interface BankAccountService {
    Optional<BankAccount> openAccount(BankAccount newAccount);
    Optional<BankAccount> closeAccount(int accountId);
    Optional<BankAccount> depositFunds(int accountId, int amount);
    Optional<BankAccount> withdrawFunds(int accountId, int amount);
    Optional<BankAccount> getAccountDetails(int accountId);
    Optional<BankAccount> reopenAccount(int accountId);
}
