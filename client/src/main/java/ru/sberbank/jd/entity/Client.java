package ru.sberbank.jd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Client {

    @Id
    private String login;

    @Column(nullable = false)
    private String password;

//    private List<Account> accounts;
}
