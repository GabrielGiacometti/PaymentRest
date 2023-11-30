package com.giacometti.gabriel.payMentRestApi.DTO;

import com.giacometti.gabriel.payMentRestApi.model.user.User;

import java.math.BigDecimal;

public record DTOListUser(Long id,String nome, String cpf, BigDecimal balance) {
    public DTOListUser(User user){
        this(user.getId(),user.getNome(), user.getCpf(), user.getBalance());
    }

}
