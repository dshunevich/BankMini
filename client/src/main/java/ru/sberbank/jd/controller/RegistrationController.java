package ru.sberbank.jd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sberbank.jd.entity.Client;
import ru.sberbank.jd.repository.ClientRepository;

@RestController
public class RegistrationController {
    PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    ClientRepository clientRepository;

    @PostMapping("api/register")
    public ResponseEntity<Void> register(@RequestBody Client client) {
        client.setPassword(encoder.encode(client.getPassword()));
        if (!clientRepository.existsByLogin(client.getLogin())) {
            clientRepository.save(client);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}