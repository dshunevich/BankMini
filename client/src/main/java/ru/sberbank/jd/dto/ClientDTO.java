package ru.sberbank.jd.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ClientDTO {
    private final String login;
    private final String password;
}
