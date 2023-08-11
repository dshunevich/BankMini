package ru.sberbank.jd.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/atm")
    public String getAccount() {
        return "ATM is OK";
    }

    @GetMapping("/client/accounts/")
    public String getAccountsForClient(Authentication auth) {
        return "accounts";
    }

    @GetMapping("/client/accounts/balance/")
    public String getClientAccountBalance(@RequestParam int accountId, Authentication auth) {
        return "account balance";
    }

}
