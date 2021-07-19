package com.example.demo2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "znatok")
public class Znatok {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "surname")
    String surname;
    @Column(name = "name")
    String name;
    @Column(name = "power")
    int power;
    @Column(name = "price")
    int price;
    @Column(name = "photo")
    String photo;

    public Znatok(String name, String surname, int power, int price, String photo) {
        this.name = name;
        this.surname = surname;
        this.power = power;
        this.price = price;
        this.photo = photo;
    }
}
