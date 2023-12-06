package com.giacometti.gabriel.payMentRestApi.DTO.user;

import com.giacometti.gabriel.payMentRestApi.model.user.User;
import com.giacometti.gabriel.payMentRestApi.model.user.UserTypeEnum;

import java.math.BigDecimal;


public record UserDetailResponseDto(Long id, String nome, String cpf, String email, UserTypeEnum type, BigDecimal balance) {
    public UserDetailResponseDto(User user){
        this(user.getId(), user.getNome(), user.getCpf(), user.getEmail(), user.getType(),user.getBalance());
    }
}
