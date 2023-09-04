package ru.sberbank.jd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.entity.BankAccount;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {
}