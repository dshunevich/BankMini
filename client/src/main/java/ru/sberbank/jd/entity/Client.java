package ru.sberbank.jd.entity;

import static jakarta.persistence.TemporalType.TIMESTAMP;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Data public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="client_id")
    private int clientId;

    @Column(name="reg_num")
    private int regNum;

    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "passport_num")
    private int passportNum;

    @Column(name = "create_dt")
    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createDt;

    @Column(name = "is_active")
    private Boolean isActive;

}
