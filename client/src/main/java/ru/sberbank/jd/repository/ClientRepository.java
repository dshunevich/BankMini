package ru.sberbank.jd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import ru.sberbank.jd.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, String> {

    Optional<Client> findByClientId(int id);

    void deleteByClientId(int id);

    boolean existsByPassportNum(int passportNum);

    boolean existsByClientIdAndIsActive(int id, Boolean active);

}
