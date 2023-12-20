package com.example.creditcardsystem.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @NotBlank(message = "Please enter Your full name")
    private String userName;

    @Email(message = "Please enter a valid email Id", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
    @NotBlank(message = "Please enter email address")
    private String emailAddress;

    @NotBlank(message = "Please enter mobile number")
    @Size(max = 10, min = 10, message = "Please enter 10 digit mobile number")
    private String phoneNumber;
    private char gender;

    @Valid
    private AddressDTO address;
}
