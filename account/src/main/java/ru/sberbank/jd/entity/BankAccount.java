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
    private String currencyCode;

    public BankAccount() {}

    public BankAccount(int clientId, String currencyCode) {
        this.clientId = clientId;
        this.active = true;
        this.currencyCode = currencyCode;
    }

    public BankAccount(int clientId, double balance, String currencyCode) {
        this.clientId = clientId;
        this.balance = balance;
        this.active = true;
        this.currencyCode = currencyCode;
    }

    public BankAccount(int clientId, double balance, boolean active, String currencyCode) {
        this.clientId = clientId;
        this.balance = balance;
        this.active = active;
        this.currencyCode = currencyCode;
    }
}
