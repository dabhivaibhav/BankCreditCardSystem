package com.example.creditcardsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "creditcarddetails")
public class CreditCardDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "credit_card_number")
    private String creditCardNumber;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @Column(name = "credit_card_limit")
    private Long creditLimit;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
