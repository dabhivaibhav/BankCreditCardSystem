package com.example.creditcardsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserResponseDTO {

    private String userName;
    private String emailAddress;
    private String phoneNumber;
    private char gender;
    private AddressDTO address;
}
