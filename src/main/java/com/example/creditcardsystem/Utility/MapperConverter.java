package com.example.creditcardsystem.Utility;

import com.example.creditcardsystem.dto.AddressDTO;
import com.example.creditcardsystem.dto.CreditCardResponseDTO;
import com.example.creditcardsystem.dto.UserRequestDTO;
import com.example.creditcardsystem.dto.UserResponseDTO;
import com.example.creditcardsystem.model.Address;
import com.example.creditcardsystem.model.CreditCardDetail;
import com.example.creditcardsystem.model.User;

public class MapperConverter {

    public static User convert(UserResponseDTO userResponseDTO){
        User user = new User();
        user.setUserName( userResponseDTO.getUserName());
        user.setEmailAddress( userResponseDTO.getEmailAddress());
        user.setPhoneNumber( userResponseDTO.getPhoneNumber());
        user.setGender( userResponseDTO.getGender());
        user.setAddress( convert(userResponseDTO.getAddress()));
        return user;
    }

    public static Address convert(AddressDTO addressDTO) {
        Address address = new Address();
        address.setApartmentName(addressDTO.getApartmentName());
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setZip(addressDTO.getZip());
        return address;
    }


    public static UserResponseDTO convert(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO(user.getUserName(),
                user.getEmailAddress(),
                user.getPhoneNumber(),
                user.getGender(),
                convert(user.getAddress()));
        return userResponseDTO;
    }

    public static AddressDTO convert(Address address) {
        AddressDTO addressDTO = new AddressDTO(address.getApartmentName(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZip());
        return addressDTO;
    }

    public static User convert(UserRequestDTO userRequestDTO){
        User user = new User();
        user.setUserName( userRequestDTO.getUserName());
        user.setEmailAddress( userRequestDTO.getEmailAddress());
        user.setPhoneNumber( userRequestDTO.getPhoneNumber());
        user.setGender( userRequestDTO.getGender());
        user.setAddress( convert(userRequestDTO.getAddress()));
        return user;
    }

    public static CreditCardResponseDTO convert(CreditCardDetail creditCardDetail) {
        CreditCardResponseDTO creditCardResponseDTO = new CreditCardResponseDTO(creditCardDetail.getCreditCardNumber(),creditCardDetail.getExpiryDate(),creditCardDetail.getCreditLimit());
        return creditCardResponseDTO;
    }
}
