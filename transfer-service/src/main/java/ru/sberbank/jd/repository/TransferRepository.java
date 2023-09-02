package ru.sberbank.jd.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.entity.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Integer> {

    List<Transfer> findByClientId (int clientId);

    Transfer findById(int id);

}
