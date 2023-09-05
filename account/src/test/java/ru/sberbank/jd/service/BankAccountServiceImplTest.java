package ru.sberbank.jd.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sberbank.jd.entity.BankAccount;
import ru.sberbank.jd.repository.BankAccountRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BankAccountServiceImplTest {

    @Mock
    private BankAccountRepository bankAccountRepository;

    @InjectMocks
    private BankAccountServiceImpl bankAccountService;

    @Test
    public void testOpenAccount() {
        BankAccount newAccount = new BankAccount(1, 1000, true, 1);

        when(bankAccountRepository.save(any(BankAccount.class))).thenReturn(newAccount);

        Optional<BankAccount> createdAccount = bankAccountService.openAccount(newAccount);

        assertEquals(createdAccount.get().getId(), newAccount.getId());
        assertEquals(createdAccount.get().getClientId(), newAccount.getClientId());
        assertEquals(createdAccount.get().getBalance(), newAccount.getBalance());
    }
}
