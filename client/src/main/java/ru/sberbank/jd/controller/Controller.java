package ru.sberbank.jd.controller;

import ru.sberbank.jd.dto.ClientDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/get/accounts/")
    public String getAccounts(@RequestBody ClientDTO client) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(client.getLogin(), client.getPassword());
        HttpEntity<Void> request = new HttpEntity<>(headers);
        String address = "http://localhost:8081/client/accounts/";
        String accounts = restTemplate.exchange(address, HttpMethod.GET, request, String.class).getBody();
        return "Numbers of accounts: " + accounts;
    }

    @PostMapping("/get/account/balance/")
    public String getAccountBalance(@RequestBody ClientDTO client, @RequestParam int accountId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(client.getLogin(), client.getPassword());
        HttpEntity<Void> request = new HttpEntity<>(headers);
        String address = "http://localhost:8081/client/accounts/balance/?accountId=" + accountId;
        String balance = restTemplate.exchange(address, HttpMethod.GET, request, String.class).getBody();
        return "Balance for account \"" + accountId + "\": " + balance;
    }
}
