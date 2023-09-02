package ru.sberbank.jd.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientInfoDto {

    private int id;
    private String firstName;
    private String lastname;
    private String fullName;
    private List<TransferDto> transfers;
    private List<AccountDto> accounts;


}
