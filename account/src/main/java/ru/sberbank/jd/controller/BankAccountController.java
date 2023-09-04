package ru.sberbank.jd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.jd.entity.BankAccount;
import ru.sberbank.jd.service.BankAccountService;
import ru.sberbank.jd.service.BankAccountServiceImpl;

import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {

    @Autowired
    private BankAccountServiceImpl bankAccountServiceImpl;

    @Autowired
    private BankAccountService bankAccountService;


    public void setBankAccountServiceImpl(BankAccountServiceImpl bankAccountServiceImpl) {
        this.bankAccountServiceImpl = bankAccountServiceImpl;
    }

    @PostMapping("/open")
    public ResponseEntity<BankAccount> openAccount(@RequestBody BankAccount newAccount) {
        Optional<BankAccount> optionalAccount = bankAccountService.openAccount(newAccount);
        return optionalAccount
                .map(account -> new ResponseEntity<>(account, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/close/{accountId}")
    public ResponseEntity<BankAccount> closeAccount(@PathVariable int accountId) {
        Optional<BankAccount> closedAccount = bankAccountServiceImpl.closeAccount(accountId);
        return closedAccount.map(account -> new ResponseEntity<>(account, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/deposit/{accountId}")
    public ResponseEntity<BankAccount> depositFunds(@PathVariable int accountId, @RequestParam int amount) {
        Optional<BankAccount> updatedAccount = bankAccountServiceImpl.depositFunds(accountId, amount);
        return updatedAccount.map(account -> new ResponseEntity<>(account, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/withdraw/{accountId}")
    public ResponseEntity<BankAccount> withdrawFunds(@PathVariable int accountId, @RequestParam int amount) {
        Optional<BankAccount> updatedAccount = bankAccountServiceImpl.withdrawFunds(accountId, amount);
        return updatedAccount.map(account -> new ResponseEntity<>(account, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<BankAccount> getAccountDetails(@PathVariable int accountId) {
        Optional<BankAccount> account = bankAccountService.getAccountDetails(accountId);
        return account
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/reopen")
    public ResponseEntity<BankAccount> reopenAccount(@RequestParam int accountId) {
        Optional<BankAccount> reopenedAccount = bankAccountService.reopenAccount(accountId);
        return reopenedAccount
                .map(account -> new ResponseEntity<>(account, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}