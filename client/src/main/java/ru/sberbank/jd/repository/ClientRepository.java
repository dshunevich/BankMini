package ru.sberbank.jd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import ru.sberbank.jd.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, String> {

    Optional<Client> findByClientId(int login);

    void deleteByClientId(int login);

    boolean existsByClientId(int login);
}
