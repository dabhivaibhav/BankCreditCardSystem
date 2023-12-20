package com.example.creditcardsystem.service;

import com.example.creditcardsystem.Utility.MapperConverter;
import com.example.creditcardsystem.dto.UserRequestDTO;
import com.example.creditcardsystem.dto.UserResponseDTO;
import com.example.creditcardsystem.model.User;
import com.example.creditcardsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(MapperConverter::convert).collect(Collectors.toList());
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = MapperConverter.convert(userRequestDTO);
        userRepository.save(user);
        return MapperConverter.convert(user);
    }

    public UserResponseDTO getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.get().getEmailAddress() != null) {
            return MapperConverter.convert(user.get());
        } else {
            return null;
        }
    }

    public void deleteUser(int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.get().getUserName()!= null)
        {
            userRepository.delete(user.get());
        }
    }
}
