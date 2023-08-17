package ru.sberbank.jd.service;

import org.springframework.stereotype.Service;
import ru.sberbank.jd.entity.Client;
import ru.sberbank.jd.repository.ClientRepository;


@Service
public class ClientService/* implements UserDetailsService*/ {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

/*    @Override
    public UserDetails loadUserByUsername(String login) {
        Optional<Client> optionalUser = clientRepository.findByLogin(login);
        Client client = optionalUser.orElseThrow(() ->
                new RuntimeException("User with current login not found"));

        return User.builder().username(client.getLogin()).password(client.getPassword()).roles().build();
    }*/

    public boolean exists(int login) {
        return clientRepository.existsByClientId(login);
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public void delete(int login) {
        clientRepository.deleteByClientId(login);
    }
}
