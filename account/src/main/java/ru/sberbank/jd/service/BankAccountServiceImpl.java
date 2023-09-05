package ru.sberbank.jd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.entity.BankAccount;
import ru.sberbank.jd.repository.BankAccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public Optional<BankAccount> openAccount(BankAccount newAccount) {
        try {
            // Validate new account information
            if (newAccount == null || newAccount.getClientId() <= 0 || newAccount.getBalance() < 0) {
                return Optional.empty();
            }

//            //Optional<BankAccount> existingAccount = bankAccountRepository.findById(newAccount.getId());
//            List<BankAccount> existingAccount = bankAccountRepository.findByClientIdAndCurrencyCode(newAccount.getClientId(), newAccount.getCurrencyCode());
//            if (!existingAccount.isEmpty()) {
//                System.err.println("Account with Cleint Id " + newAccount.getClientId() + " and currency " + newAccount.getCurrencyCode() + " is already exists!");
//                return Optional.empty(); // Account with the same ID already exists
//            }

            // Create and save the new account
            BankAccount createdAccount = bankAccountRepository.save(newAccount);
            return Optional.of(createdAccount);
        } catch (Exception e) {
            System.err.println("Error opening new account: " + e.getMessage());
            return Optional.empty();
        }
    }


    @Override
    public Optional<BankAccount> reopenAccount(int accountId) {
        Optional<BankAccount> optionalAccount = bankAccountRepository.findById(accountId);

        if (optionalAccount.isPresent()) {
            BankAccount account = optionalAccount.get();
            account.setActive(true);
            bankAccountRepository.save(account);
            return Optional.of(account);
        } else {
            System.err.println("Account not found for ID: " + accountId);
            return Optional.empty();
        }
    }

    @Override
    public Optional<BankAccount> closeAccount(int id) {
        Optional<BankAccount> account = bankAccountRepository.findById(id);
        if (account.isPresent()) {
            BankAccount existingAccount = account.get();
            existingAccount.setActive(false);
            bankAccountRepository.save(existingAccount);
            return Optional.of(existingAccount);
        }
        return Optional.empty();
    }

    public Optional<BankAccount> depositFunds(int accountId, int amount) {
        Optional<BankAccount> optionalAccount = bankAccountRepository.findById(accountId);

        if (optionalAccount.isPresent()) {
            BankAccount account = optionalAccount.get();

            // Check if the account is active
            if (!account.isActive()) {
                System.err.println("Account with ID: " + accountId + "is inactive, cannot deposit funds!");
                return Optional.empty(); // Account is inactive, cannot deposit funds
            }

            // Proceed with the deposit
            double currentBalance = account.getBalance();
            double newBalance = currentBalance + amount;
            account.setBalance(newBalance);
            bankAccountRepository.save(account);
            return Optional.of(account);
        } else {
            System.err.println("Account not found for ID: " + accountId);
            return Optional.empty();
        }
    }

    public Optional<BankAccount> withdrawFunds(int accountId, int amount) {
        Optional<BankAccount> optionalAccount = bankAccountRepository.findById(accountId);

        if (optionalAccount.isPresent()) {
            BankAccount account = optionalAccount.get();

            // Check if the account is active
            if (!account.isActive()) {
                System.err.println("Account with ID: " + accountId + "is inactive, cannot deposit funds!");
                return Optional.empty(); // Account is inactive, cannot withdraw funds
            }

            double currentBalance = account.getBalance();

            // Check if sufficient funds are available
            if (currentBalance >= amount) {
                double newBalance = currentBalance - amount;
                account.setBalance(newBalance);
                bankAccountRepository.save(account);
                return Optional.of(account);
            } else {
                System.err.println("Account with ID: " + accountId + ": currentBalance < amount");
                return Optional.empty();
            }
        } else {
            System.err.println("Account not found for ID: " + accountId);
            return Optional.empty();
        }
    }

    @Override
    public Optional<BankAccount> getAccountDetails(int accountId) {
        return bankAccountRepository.findById(accountId);
    }

}
