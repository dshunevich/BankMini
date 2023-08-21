package ru.sberbank.jd.service;

import java.util.Date;
import java.util.Optional;
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
        return clientRepository.existsByPassportNumAndIsActive(passportNum, true);
    }
    public boolean existsAndActive(int id) {
        return clientRepository.existsByClientIdAndIsActive(id, true);
    }

    public void save(Client client) {
        Optional<Client> c = clientRepository.findByPassportNum(client.getPassportNum());
        c.ifPresent(value -> {
            client.setRegNum(value.getRegNum() + 1);
            client.setClientId(c.get().getClientId());
        });
        client.setIsActive(true);
        client.setCreateDt(new Date());
        clientRepository.save(client);
    }
    public void update(Client client) {
        Client c = clientRepository.findByPassportNum(client.getPassportNum()).get();
        client.setClientId(c.getClientId());
        client.setIsActive(true);
        clientRepository.save(client);
    }

    public void delete(int id) {
        Client client = clientRepository.findByClientId(id).get();
        client.setIsActive(false);
        clientRepository.save(client);
    }
 /*   @Autowired
    public void initData() {
        Client client = new Client(1, "df", "df", "df", 2, new Date(), true);
        clientRepository.save(client);
        client.setPassword("update");
        clientRepository.save(client);
    }*/
}
