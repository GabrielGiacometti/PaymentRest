package com.giacometti.gabriel.payMentRestApi.decorator;

import com.giacometti.gabriel.payMentRestApi.model.user.User;

import java.math.BigDecimal;

public class UnderPaymentDecorator implements TransactionValidation{
    User user;
    BigDecimal value;
    public UnderPaymentDecorator(User user, BigDecimal value){
        this.user = user;
        this.value = value;
    }

    @Override
    public void validate() throws RuntimeException {
        if(user.getBalance().compareTo(value)<0) throw new RuntimeException("Payer do not have enough money");
    }
}
