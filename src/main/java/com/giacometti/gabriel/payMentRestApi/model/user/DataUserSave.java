package com.giacometti.gabriel.payMentRestApi.model.user;

import java.math.BigInteger;

public record DataUserSave(String nome, String cpf, String email, String senha, UserTypeEnum type, BigInteger balance) {
}
