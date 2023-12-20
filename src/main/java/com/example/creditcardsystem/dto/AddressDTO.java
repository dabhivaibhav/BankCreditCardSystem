package com.example.creditcardsystem.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    @NotBlank(message = "Please enter correct apartment name")
    @Size(min = 3, message = "Apartment name cannot be less than 3 letters")
    private String apartmentName;

    @NotBlank(message = "Please enter correct street name")
    @Size(min = 3)
    private String street;

    @NotBlank(message = "Please enter correct city name")
    @Size(min = 3, message = "city name cannot be less than 3 letters")
    private String city;

    @NotBlank(message = "Please enter correct state name")
    @Size(min = 3)
    private String state;

    @NotBlank(message = "Please enter correct zip name")
    @Size(min = 3)
    private String zip;
}
