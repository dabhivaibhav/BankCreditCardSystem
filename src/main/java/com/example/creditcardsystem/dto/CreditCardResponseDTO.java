package com.example.creditcardsystem.dto;

import com.example.creditcardsystem.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardResponseDTO {

    private String creditCardNumber;
    private Date expiryDate;
    private Long creditLimit;
}
