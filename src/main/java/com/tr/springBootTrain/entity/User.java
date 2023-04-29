package com.tr.springBootTrain.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "USERS")
@Data
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", length = 100)
    private String name;
    @Column(name = "SURNAME", length = 200)
    private String surname;
}
