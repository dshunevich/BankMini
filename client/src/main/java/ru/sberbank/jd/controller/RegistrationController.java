package ru.sberbank.jd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import ru.sberbank.jd.dto.ClientDTO;
import ru.sberbank.jd.entity.Client;
import ru.sberbank.jd.service.ClientService;

@Controller
public class RegistrationController {
    @Autowired
    ClientService clientService;

    @GetMapping("/registration")
    public String registrationGet(Model model){
        model.addAttribute("client", new Client());
        return "registration";
    }

    @PostMapping("/registration")
//    public String registrationPost(@ModelAttribute Client client, Model model) {
    public ResponseEntity<Void> registrationPost(@RequestBody Client client, Model model) {
        if (!clientService.exists(client.getPassportNum())) {
            clientService.save(client);
            model.addAttribute("client", client);
        }
        else {
            model.addAttribute("userError", true);
            model.addAttribute("errorMessage", "User registration error");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            return "error";
        }
//        returtn "succes";
        return new ResponseEntity<>(HttpStatus.OK);
    }
}