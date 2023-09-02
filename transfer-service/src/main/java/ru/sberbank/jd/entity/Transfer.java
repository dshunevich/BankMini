package ru.sberbank.jd.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Data
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @JsonProperty(value = "writeOffAccountId")
    private int sourceAccountId;

    @Column(nullable = false)
    @JsonProperty(value = "accrualAccountId")
    private int targetAccountId;

    private int clientId;

    private int toClientId;

    private Currency currency;

    private double sum;

    private LocalDateTime submitDateTime;

    private TransferStatus status;

}
