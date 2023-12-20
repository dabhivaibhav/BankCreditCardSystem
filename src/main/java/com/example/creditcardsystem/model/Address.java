package com.example.creditcardsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "apartment_name")
    private String apartmentName;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name = "zip")
    private String zip;
}
