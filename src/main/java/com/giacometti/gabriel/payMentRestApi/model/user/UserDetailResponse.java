package com.giacometti.gabriel.payMentRestApi.model.user;

import java.math.BigDecimal;


public record UserDetailResponse(Long id, String nome, String cpf, String email, UserTypeEnum type, BigDecimal balance) {
    public UserDetailResponse(User user){
        this(user.getId(), user.getNome(), user.getCpf(), user.getEmail(), user.getType(),user.getBalance());
    }
}
