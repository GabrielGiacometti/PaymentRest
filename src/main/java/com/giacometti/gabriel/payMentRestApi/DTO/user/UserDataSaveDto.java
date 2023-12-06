package com.giacometti.gabriel.payMentRestApi.DTO.user;

import com.giacometti.gabriel.payMentRestApi.model.user.UserTypeEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UserDataSaveDto(
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
        @Enumerated(EnumType.STRING)
        UserTypeEnum type,
        BigDecimal balance) {
}
