package com.example.creditcardsystem.service;

import com.example.creditcardsystem.Utility.MapperConverter;
import com.example.creditcardsystem.dto.CreditCardResponseDTO;
import com.example.creditcardsystem.model.CreditCardDetail;
import com.example.creditcardsystem.model.User;
import com.example.creditcardsystem.repository.CreditCardRepository;
import com.example.creditcardsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CreditCardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    public CreditCardResponseDTO createCreditCard(int id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if(user!= null){
            CreditCardDetail creditCardDetail = new CreditCardDetail();
            creditCardDetail.setCreditCardNumber(String.valueOf(generateCreditCardNumber()));
            creditCardDetail.setExpiryDate(generateExpiryDate());
            creditCardDetail.setCreditLimit(generateCreditCardLimit());
            creditCardDetail.setUser(user.get());
            creditCardRepository.save(creditCardDetail);
            return MapperConverter.convert(creditCardDetail);
        }else{
            throw new Exception("User Not Found!!");
        }
    }

    public CreditCardResponseDTO getUserCreditCardDetails(int id){
        CreditCardDetail creditCardDetail = creditCardRepository.findById(userRepository.findById(id).get().getCreditCardDetails().getId()).get();
        return MapperConverter.convert(creditCardDetail);

    }
    private static long generateCreditCardNumber() {
        /* return a random long of 16 length */
        long smallest = 0001_0000_0000_0000L;
        long biggest =  9999_9999_9999_9999L;

        // return a long between smallest and biggest (+1 to include biggest as well with the upper bound)
        long random = ThreadLocalRandom.current().nextLong(smallest, biggest+1);
        return random;
    }

    private long generateCreditCardLimit(){
        long creditLimit = ThreadLocalRandom.current().nextInt(10, 50) * 1000;
        return creditLimit;
    }

    private Date generateExpiryDate(){
        LocalDate now =  LocalDate.now();
        LocalDate sameDayNextYear = now.plusYears(1).minusDays(1);
        return Date.valueOf(sameDayNextYear);
    }
}
