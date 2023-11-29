package com.giacometti.gabriel.payMentRestApi.service;

import com.giacometti.gabriel.payMentRestApi.model.user.User;
import com.giacometti.gabriel.payMentRestApi.model.user.UserRepository;
import com.giacometti.gabriel.payMentRestApi.model.user.UserTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class TransactionService {
    @Autowired
    private UserRepository userRepository;
    public void trasaction(User payer, User receiver, BigDecimal value) throws RuntimeException{
        if(payer.getType() == UserTypeEnum.COMUM) throw new RuntimeException("Only shopkeepers can make transactions");
        if(payer.getBalance().compareTo(value) <0) throw new RuntimeException("Payer do not have enough money");

        payer.setBalance(payer.getBalance().subtract(value));
        receiver.setBalance(receiver.getBalance().add(value));

    }


}
