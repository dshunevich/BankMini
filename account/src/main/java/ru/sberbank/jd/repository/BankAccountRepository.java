package ru.sberbank.jd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.entity.BankAccount;

//import java.util.List;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {
    //// Custom query method to find accounts by clientId and currency
    //List<BankAccount> findByClientIdAndCurrencyCode(int clientId, String currencyCode);
}