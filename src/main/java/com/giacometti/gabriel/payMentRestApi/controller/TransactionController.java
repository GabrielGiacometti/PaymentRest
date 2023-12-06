package com.giacometti.gabriel.payMentRestApi.controller;

import com.giacometti.gabriel.payMentRestApi.DTO.transaction.ResponseTransactionDto;
import com.giacometti.gabriel.payMentRestApi.DTO.transaction.MakeTransactionDto;
import com.giacometti.gabriel.payMentRestApi.model.transaction.TransactionRepository;
import com.giacometti.gabriel.payMentRestApi.model.user.UserRepository;
import com.giacometti.gabriel.payMentRestApi.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RequestMapping("transaction")
@RestController
public class TransactionController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionService transactionService;

    @PostMapping()
    @Transactional
    public ResponseEntity doTransaction(@RequestBody @Valid MakeTransactionDto data, UriComponentsBuilder uriBuilder){
        var transaction = transactionService.transaction(data);

        var uri = uriBuilder.path("/transaction/{id}").buildAndExpand(transaction.getId()).toUri();
        return ResponseEntity.created(uri).body(new ResponseTransactionDto(transaction));
    }

    @GetMapping("/{id}")
    public ResponseEntity detailTransaction(@PathVariable Long id){
        var transaction = transactionRepository.findById(id).get();

        return ResponseEntity.ok(new ResponseTransactionDto(transaction));
    }

}
