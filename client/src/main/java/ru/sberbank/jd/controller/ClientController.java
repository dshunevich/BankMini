package ru.sberbank.jd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.sberbank.jd.dto.ClientDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.sberbank.jd.entity.Client;
import ru.sberbank.jd.service.ClientService;

@RestController
public class ClientController {

    private final RestTemplate restTemplate = new RestTemplate();

//    PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    ClientService clientService;

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(int id) {
        if (clientService.existsAndActive(id)) {
            clientService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/update")
    public ResponseEntity<Void> update(int id) {
        if (clientService.existsAndActive(id)) {
            clientService.update(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody Client client) {
//        client.setPassword(encoder.encode(client.getPassword()));
        if (!clientService.exists(client.getPassportNum())) {
            clientService.save(client);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get/accounts/")
    public String getAccounts(@RequestBody ClientDTO client) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(client.getLogin(), client.getPassword());
        HttpEntity<Void> request = new HttpEntity<>(headers);
        String address = "http://localhost:8081/client/accounts/";
        String accounts = restTemplate.exchange(address, HttpMethod.GET, request, String.class).getBody();
        return "Numbers of accounts: " + accounts;
    }

    @GetMapping("/get/account/balance/")
    public String getAccountBalance(@RequestBody ClientDTO client, @RequestParam int accountId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(client.getLogin(), client.getPassword());
        HttpEntity<Void> request = new HttpEntity<>(headers);
        String address = "http://localhost:8081/client/accounts/balance/?accountId=" + accountId;
        String balance = restTemplate.exchange(address, HttpMethod.GET, request, String.class).getBody();
        return "Balance for account \"" + accountId + "\": " + balance;
    }
}
