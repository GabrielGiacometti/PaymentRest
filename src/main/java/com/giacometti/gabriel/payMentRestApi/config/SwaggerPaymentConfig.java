package com.giacometti.gabriel.payMentRestApi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(name="Gabriel Giacometti",
                email = "giacometti@gmail.com"),
                description = "This is a PAYMENT API",
                title = "Payment API - Giacometti")


)
public class SwaggerPaymentConfig {
}
