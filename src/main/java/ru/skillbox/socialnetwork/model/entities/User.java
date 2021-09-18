package ru.skillbox.socialnetwork.model.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "e_mail")
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 16)
    private UserType type;
}
