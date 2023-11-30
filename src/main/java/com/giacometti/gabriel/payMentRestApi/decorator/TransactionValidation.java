package com.giacometti.gabriel.payMentRestApi.decorator;


public interface TransactionValidation {
   abstract public void  validate () throws RuntimeException;
}
