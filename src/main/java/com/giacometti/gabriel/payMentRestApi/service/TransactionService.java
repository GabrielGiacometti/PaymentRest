package com.giacometti.gabriel.payMentRestApi.service;

import com.giacometti.gabriel.payMentRestApi.DTO.transaction.MakeTransactionDto;
import com.giacometti.gabriel.payMentRestApi.decorator.TransactionValidation;
import com.giacometti.gabriel.payMentRestApi.decorator.TypeValidationDecorator;
import com.giacometti.gabriel.payMentRestApi.decorator.UnderPaymentDecorator;
import com.giacometti.gabriel.payMentRestApi.model.email.Email;
import com.giacometti.gabriel.payMentRestApi.model.transaction.Transaction;
import com.giacometti.gabriel.payMentRestApi.model.transaction.TransactionRepository;
import com.giacometti.gabriel.payMentRestApi.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class TransactionService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private SendTransactionEmail sendTransactionEmail;
    private TransactionValidation transactionValidation;
    public Transaction transaction(MakeTransactionDto data) throws RuntimeException{
        var payer = userRepository.getReferenceById(data.payer());
        var receiver = userRepository.getReferenceById(data.receiver());
        var value = data.value();

        transactionValidation = new TypeValidationDecorator(payer,
                                        new UnderPaymentDecorator(payer,value));
        transactionValidation.validate();

        payer.setBalance(payer.getBalance().subtract(value));
        receiver.setBalance(receiver.getBalance().add(value));

        var transaction = new Transaction(payer,receiver,value);
        sendTransactionEmail.send(new Email(receiver.getEmail()).setEmailToReceiver(value, payer.getEmail()));
        sendTransactionEmail.send(new Email(payer.getEmail()).setEmailToPayer(value, receiver.getEmail()));
        transactionRepository.save(transaction);

        return  transaction;

    }


}
