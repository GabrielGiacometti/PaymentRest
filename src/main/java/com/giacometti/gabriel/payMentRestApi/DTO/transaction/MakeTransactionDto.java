package com.giacometti.gabriel.payMentRestApi.DTO.transaction;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record MakeTransactionDto(
        @NotNull Long payer,
        @NotNull Long receiver,
        @NotNull BigDecimal value){
}
