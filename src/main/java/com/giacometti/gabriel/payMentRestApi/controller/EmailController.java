package com.giacometti.gabriel.payMentRestApi.controller;

import com.giacometti.gabriel.payMentRestApi.DTO.email.ListEmailDTO;
import com.giacometti.gabriel.payMentRestApi.DTO.user.ListUserDto;
import com.giacometti.gabriel.payMentRestApi.model.email.EmailRespository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping ("email")
@RestController
@Tag(name="Email")

public class EmailController {
    @Autowired
    private EmailRespository emailRespository;
    @GetMapping
    @Operation(summary = "Get all emails")
    @Parameter(name = "sort", schema = @Schema(type = "string", defaultValue = "emailId"))
    public ResponseEntity<Page> listar(@PageableDefault(size= 10) Pageable pageable) {
        var page = emailRespository.findAll(pageable).map(ListEmailDTO::new);
        return ResponseEntity.ok(page);
    }
}
