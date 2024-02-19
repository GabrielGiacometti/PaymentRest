package com.giacometti.gabriel.payMentRestApi.service;

import com.giacometti.gabriel.payMentRestApi.model.email.Email;
import com.giacometti.gabriel.payMentRestApi.model.email.EmailRespository;
import com.giacometti.gabriel.payMentRestApi.model.email.StatusEmail;
import com.giacometti.gabriel.payMentRestApi.model.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SendTransactionEmail {
    @Autowired
    private EmailRespository emailRespository;
    private Email email;

    @Autowired
    private JavaMailSender emailSender;

    public void send(Email email) {
         this.email = email;
        email.setSendDateEmail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(email.getSender());
            message.setTo(email.getReceiver());
            message.setSubject(email.getTitle());
            message.setText(email.getText());
            System.out.println(email.getSender());
            System.out.println(email.getReceiver());
            emailSender.send(message);
            email.setStatusEmail(StatusEmail.SEND);

        } catch (MailException e) {
            email.setStatusEmail(StatusEmail.ERROR);
            System.out.println(e.getMessage());
        }finally {
            emailRespository.save(email);
        }


    }
}
