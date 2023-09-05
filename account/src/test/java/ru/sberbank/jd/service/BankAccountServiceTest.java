package ru.sberbank.jd.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import ru.sberbank.jd.entity.BankAccount;
import ru.sberbank.jd.repository.BankAccountRepository;

@ExtendWith(MockitoExtension.class)
class BankAccountServiceTest {

    @InjectMocks
    private BankAccountServiceImpl bankAccountService;

    @Mock
    private BankAccountRepository bankAccountRepository;

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount();
        bankAccount.setId(1);
        bankAccount.setBalance(1000.0);
        bankAccount.setClientId(1);
    }

    @Test
    void testGetAccountById() {
        when(bankAccountRepository.findById(1)).thenReturn(Optional.of(bankAccount));

        Optional<BankAccount> foundAccount = bankAccountService.getAccountDetails(1);

        assertTrue(foundAccount.isPresent());
        assertEquals(bankAccount, foundAccount.get());
    }

//    @Test
//    void testOpenAccount() {
//        when(bankAccountRepository.save(any(BankAccount.class))).thenReturn(bankAccount);
//
//        BankAccount createdAccount = bankAccountService.openAccount(bankAccount).orElse(null);
//
//        assertEquals(bankAccount, createdAccount);
//    }

//    @Test
//    void testDepositFunds() {
//        when(bankAccountRepository.findById(1)).thenReturn(Optional.of(bankAccount));
//
//        Optional<BankAccount> updatedAccount = bankAccountService.depositFunds(1, 100);
//
//        assertTrue(updatedAccount.isPresent());
//        assertEquals(1100.0, updatedAccount.get().getBalance());
//    }
//
//    @Test
//    void testWithdrawFunds() {
//        when(bankAccountRepository.findById(1)).thenReturn(Optional.of(bankAccount));
//
//        Optional<BankAccount> updatedAccount = bankAccountService.withdrawFunds(1, 100);
//
//        assertTrue(updatedAccount.isPresent());
//        assertEquals(900.0, updatedAccount.get().getBalance());
//    }

    @Test
    void testCloseAccount() {
        when(bankAccountRepository.findById(1)).thenReturn(Optional.of(bankAccount));

        Optional<BankAccount> closedAccount = bankAccountService.closeAccount(1);

        assertTrue(closedAccount.isPresent());
        assertFalse(closedAccount.get().isActive());
    }

}