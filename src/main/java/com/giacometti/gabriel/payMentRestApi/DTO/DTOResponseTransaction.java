package com.giacometti.gabriel.payMentRestApi.DTO;

import com.giacometti.gabriel.payMentRestApi.model.transaction.Transaction;
import com.giacometti.gabriel.payMentRestApi.model.user.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DTOResponseTransaction(Long transactionId,String payer, String receiver, BigDecimal value,
                                     LocalDateTime time) {
    public DTOResponseTransaction(Transaction transaction){
        this(transaction.getId(), transaction.getPayer().getNome(), transaction.getReceiver().getNome(), transaction.getValue(),transaction.getDate());
    }
}
