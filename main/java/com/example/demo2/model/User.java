package com.example.demo2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "login")
    private String login;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String passw;
    @Column(name = "repeat_password")
    private String passw_repeat;

    public User(String login, String email, String passw, String passw_repeat) {
        this.login = login;
        this.email = email;
        this.passw = passw;
        this.passw_repeat = passw_repeat;
    }
}
