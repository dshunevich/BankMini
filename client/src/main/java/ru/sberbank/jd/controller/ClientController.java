package ru.sberbank.jd.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.sberbank.jd.dto.ClientDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.sberbank.jd.entity.Client;
import ru.sberbank.jd.service.ClientService;

@Controller
@AllArgsConstructor
public class ClientController {

    private final RestTemplate restTemplate;

    private final ClientService clientService;

    @GetMapping("/")
    public String rootGet(@ModelAttribute Client client, Model model) {
        model.addAttribute("client", new Client());
        return "index";
    }

    /*@GetMapping("/get/account/balance/")
    public String getAccountBalance(@RequestBody ClientDTO client, @RequestParam int accountId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(client.getLogin(), client.getPassword());
        HttpEntity<Void> request = new HttpEntity<>(headers);
        String address = "http://localhost:8081/client/accounts/balance/?accountId=" + accountId;
        String balance = restTemplate.exchange(address, HttpMethod.GET, request, String.class).getBody();
        return "Balance for account \"" + accountId + "\": " + balance;
    }*/
}
