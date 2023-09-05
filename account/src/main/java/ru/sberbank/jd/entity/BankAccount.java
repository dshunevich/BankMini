package ru.sberbank.jd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int clientId;
    private double balance;
    private boolean active;
    private int currencyId;

    public BankAccount() {}

    public BankAccount(int clientId, int currencyId) {
        this.clientId = clientId;
        this.active = true;
        this.currencyId = currencyId;
    }

    public BankAccount(int clientId, double balance, int currencyId) {
        this.clientId = clientId;
        this.balance = balance;
        this.active = true;
        this.currencyId = currencyId;
    }

    public BankAccount(int clientId, double balance, boolean active, int currencyId) {
        this.clientId = clientId;
        this.balance = balance;
        this.active = active;
        this.currencyId = currencyId;
    }
}
