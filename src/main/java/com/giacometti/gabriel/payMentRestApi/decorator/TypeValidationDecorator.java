package com.giacometti.gabriel.payMentRestApi.decorator;

import com.giacometti.gabriel.payMentRestApi.model.user.User;
import com.giacometti.gabriel.payMentRestApi.model.user.UserTypeEnum;



public class TypeValidationDecorator extends DecoratorTrasanctionValidation implements TransactionValidation{
    private User user;
    public TypeValidationDecorator(User user,TransactionValidation next) {
        super(next);
        this.user = user;
    }

    @Override
    public void validate() throws RuntimeException {
        if(user.getType().equals(UserTypeEnum.COMUM)) throw new RuntimeException("Comum users can not make transactions");
        super.validate();
    }
}
