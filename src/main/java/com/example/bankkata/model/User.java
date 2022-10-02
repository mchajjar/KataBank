package com.example.bankkata.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "KataUser")
public class User {

    @Id
    @Column(name="cin")
    private Integer cin;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="dateOfBirth")
    private LocalDate dateOfBirth;

    @Column(name="creationDate")
    private LocalDate creationDate;

    @Column(name="modificationDate")
    private LocalDate modificationDate;


    @Column(name="jobTitle")
    private String jobTitle;


}
