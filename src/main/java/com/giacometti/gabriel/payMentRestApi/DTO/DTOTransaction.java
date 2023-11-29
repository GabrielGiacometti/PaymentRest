package com.giacometti.gabriel.payMentRestApi.DTO;

import com.giacometti.gabriel.payMentRestApi.model.user.User;

import java.math.BigDecimal;
import java.math.BigInteger;

public record DTOTransaction(Long payerId, BigDecimal payerBalanceActual, Long receiverId, BigDecimal receiverBalanceActual, BigDecimal transactionValue) {
    public DTOTransaction(User payer, User receiver, BigDecimal transactionValue){
        this(payer.getId(), payer.getBalance(), receiver.getId(), receiver.getBalance(), transactionValue);
    }
}
