package com.giacometti.gabriel.payMentRestApi.decorator;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class DecoratorTrasanctionValidation implements TransactionValidation {
    private TransactionValidation next;

    public DecoratorTrasanctionValidation(TransactionValidation next){
        this.next = next;
    }


    public void validate() throws RuntimeException{
       next.validate();
     }


}
