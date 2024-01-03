package com.unitTesting.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Persons")
public class Person {

    @Id
    @Column(name = "personIds",nullable = false)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer personId;
    private String personName;
    private String personCity;


}
