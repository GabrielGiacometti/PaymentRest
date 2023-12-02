package com.giacometti.gabriel.payMentRestApi.model.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;

public record UserDataSave(
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @NotBlank
        //@Email
        String email,
        @NotBlank
        String senha,
        @NotNull
        UserTypeEnum type,
        BigDecimal balance) {
}
