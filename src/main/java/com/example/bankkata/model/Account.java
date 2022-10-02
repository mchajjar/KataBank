package com.example.bankkata.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import com.example.bankkata.enums.AccountType;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Account {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private AccountType type;

    @Column(name="surname")
    private String surname;

    @Column(name="creationDate")
    private LocalDate creationDate;

    @Column(name="modificationDate")
    private LocalDate modificationDate;

    @ManyToOne
    private User userId;

    @Column(name="amount")
    private Double amount;
}
