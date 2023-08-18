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

    public boolean exists(int passportNum) {
        return clientRepository.existsByPassportNum(passportNum);
    }
    public boolean existsAndActive(int id) {
        return clientRepository.existsByClientIdAndIsActive(id, true);
    }

    public void save(Client client) {
        client.setIsActive(true);
        clientRepository.save(client);
    }
    public void update(int id) {
        Client client = clientRepository.findByClientId(id).get();
        client.setIsActive(true);
        clientRepository.save(client);
    }

    public void delete(int id) {
        clientRepository.deleteByClientId(id);
    }
}
