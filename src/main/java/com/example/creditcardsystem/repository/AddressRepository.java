package com.example.creditcardsystem.repository;

import com.example.creditcardsystem.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
