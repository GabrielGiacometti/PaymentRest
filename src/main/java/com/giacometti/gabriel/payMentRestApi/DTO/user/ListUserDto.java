package com.giacometti.gabriel.payMentRestApi.DTO.user;

import com.giacometti.gabriel.payMentRestApi.model.user.User;

import java.math.BigDecimal;

public record ListUserDto(Long id, String nome, String cpf, BigDecimal balance) {
    public ListUserDto(User user){
        this(user.getId(),user.getNome(), user.getCpf(), user.getBalance());
    }

}
