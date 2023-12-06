package com.giacometti.gabriel.payMentRestApi.DTO.transaction;

import com.giacometti.gabriel.payMentRestApi.model.transaction.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ResponseTransactionDto(Long transactionId, String payer, String receiver, BigDecimal value,
                                     LocalDateTime time) {
    public ResponseTransactionDto(Transaction transaction){
        this(transaction.getId(), transaction.getPayer().getNome(), transaction.getReceiver().getNome(), transaction.getValue(),transaction.getDate());
    }
}
