package ru.sberbank.jd.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransferDto {

    //id операции
    private int id;
    //счет списания
    private int writeOffAccountId;
    //счет зачисления
    private int accrualAccountId;
    private double sum;
    private Currency currency;

}
