package com.giacometti.gabriel.payMentRestApi.DTO;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DTOMakeTransaction(
        @NotNull Long payer,
        @NotNull Long receiver,
        @NotNull BigDecimal value){
}
