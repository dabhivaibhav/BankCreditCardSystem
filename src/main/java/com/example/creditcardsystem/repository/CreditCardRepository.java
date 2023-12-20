package com.example.creditcardsystem.repository;

import com.example.creditcardsystem.model.CreditCardDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository  extends JpaRepository<CreditCardDetail, Integer> {



}
