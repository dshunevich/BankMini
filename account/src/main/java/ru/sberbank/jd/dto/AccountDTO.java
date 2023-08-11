package ru.sberbank.jd.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AccountDTO {
    private final int accountId;
    private final int accountBalance;
}
