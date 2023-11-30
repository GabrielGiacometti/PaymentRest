package com.giacometti.gabriel.payMentRestApi.service;

import com.giacometti.gabriel.payMentRestApi.decorator.TransactionValidation;
import com.giacometti.gabriel.payMentRestApi.decorator.TypeValidationDecorator;
import com.giacometti.gabriel.payMentRestApi.decorator.UnderPaymentDecorator;
import com.giacometti.gabriel.payMentRestApi.model.user.User;
import com.giacometti.gabriel.payMentRestApi.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {
    @Autowired
    private UserRepository userRepository;

    private TransactionValidation transactionValidation;
    public void transaction(User payer, User receiver, BigDecimal value) throws RuntimeException{
        transactionValidation = new TypeValidationDecorator(payer,
                                        new UnderPaymentDecorator(payer,value));
        transactionValidation.validate();


        payer.setBalance(payer.getBalance().subtract(value));
        receiver.setBalance(receiver.getBalance().add(value));
    }


}
