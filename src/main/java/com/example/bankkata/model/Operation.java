package com.example.bankkata.model;

import com.example.bankkata.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Operation {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="type")
    private OperationType type;

    @Column(name="amount")
    private OperationType amount;

    @Column(name="executionDate")
    private LocalDate executionDate;

    @Column(name="realDate")
    private LocalDate realDate;

    @OneToOne
    @JoinColumn(name="userFrom")
    private User userFrom;

    @OneToOne
    @JoinColumn(name="accountFrom")
    private Account accountFrom;

}
