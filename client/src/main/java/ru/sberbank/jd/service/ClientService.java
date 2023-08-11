package ru.sberbank.jd.service;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.dto.ClientDTO;
import ru.sberbank.jd.entity.Client;
import ru.sberbank.jd.repository.ClientRepository;


@Service
public class ClientService implements UserDetailsService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) {
        Optional<Client> optionalUser = clientRepository.findByLogin(login);
        Client client = optionalUser.orElseThrow(() ->
                new RuntimeException("User with current login not found"));

        return User.builder().username(client.getLogin()).password(client.getPassword()).roles().build();
    }

    public ClientDTO getClientByLogin(String login) {
        Optional<Client> optionalUser = clientRepository.findByLogin(login);
        Client rawClient = optionalUser.orElseThrow(() ->
                new RuntimeException("User with current login not found"));

        return new ClientDTO(rawClient.getLogin(), rawClient.getPassword());
    }

}
