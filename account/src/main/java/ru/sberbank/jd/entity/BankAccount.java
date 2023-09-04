package ru.sberbank.jd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BankAccount {
    @Id
    private int id;
    private int clientId;
    private double balance;
    private boolean active;

    public BankAccount() {}

    public BankAccount(int id, int clientId, double balance, boolean active) {
        this.id = id;
        this.clientId = clientId;
        this.balance = balance;
        this.active = active;
    }
}
