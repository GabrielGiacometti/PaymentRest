package com.giacometti.gabriel.payMentRestApi.controller;

import com.giacometti.gabriel.payMentRestApi.DTO.DTOResponseTransaction;
import com.giacometti.gabriel.payMentRestApi.DTO.DTOMakeTransaction;
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
    public ResponseEntity doTransaction(@RequestBody @Valid DTOMakeTransaction data, UriComponentsBuilder uriBuilder){
        var payerUser = userRepository.getReferenceById(data.payer());
        var receiverUser = userRepository.getReferenceById(data.receiver());

        var transaction = transactionService.transaction(payerUser,receiverUser, data.value());
        var uri = uriBuilder.path("/transaction/{id}").buildAndExpand(transaction.getId()).toUri();
        return ResponseEntity.created(uri).body(new DTOResponseTransaction(transaction));

    }

    @GetMapping("/{id}")
    public ResponseEntity detailTransaction(@PathVariable Long id){
        var transaction = transactionRepository.findById(id).get();

        return ResponseEntity.ok(new DTOResponseTransaction(transaction));
    }

}
