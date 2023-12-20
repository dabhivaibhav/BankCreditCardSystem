package com.example.creditcardsystem.controller;

import com.example.creditcardsystem.dto.CreditCardResponseDTO;
import com.example.creditcardsystem.dto.UserRequestDTO;
import com.example.creditcardsystem.dto.UserResponseDTO;
import com.example.creditcardsystem.model.User;
import com.example.creditcardsystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser( @Valid @RequestBody UserRequestDTO userRequestDTO){
        return new ResponseEntity<UserResponseDTO>(userService.createUser(userRequestDTO),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsersDetails(){
        return new ResponseEntity<List<UserResponseDTO>>(userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("id") int id){
        return new ResponseEntity<UserResponseDTO>(userService.getUserById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }


}
