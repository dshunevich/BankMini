package ru.sberbank.jd.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ClientDTO {
    private final String login;
    private final String password;
}
