package ru.sberbank.jd.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ClientDTO {
    private final String login;
    private final String password;
    private final List<AccountDTO> accountDTOs;
}
