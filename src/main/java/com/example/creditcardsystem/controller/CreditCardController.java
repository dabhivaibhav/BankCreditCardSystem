package com.example.creditcardsystem.controller;

import com.example.creditcardsystem.dto.CreditCardResponseDTO;
import com.example.creditcardsystem.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/creditcard")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;
    @PostMapping("/{userid}")
    public ResponseEntity<CreditCardResponseDTO> createCreditCard(@PathVariable("userid") int id) throws Exception {

        return  new ResponseEntity<CreditCardResponseDTO>( creditCardService.createCreditCard(id), HttpStatus.CREATED);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<CreditCardResponseDTO> getCreditCardDetails(@PathVariable("userid") int id) throws Exception {
        return  new ResponseEntity<CreditCardResponseDTO>( creditCardService.getUserCreditCardDetails(id), HttpStatus.CREATED);
    }
}
