package com.giacometti.gabriel.payMentRestApi.controller;

import com.giacometti.gabriel.payMentRestApi.DTO.DTOTransaction;
import com.giacometti.gabriel.payMentRestApi.model.user.UserRepository;
import com.giacometti.gabriel.payMentRestApi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;


@RequestMapping("transaction")
@RestController
public class TransactionController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransactionService transactionService;

    @PostMapping()
    @Transactional
    public ResponseEntity doTransaction(@RequestParam("payer")Long idPayer,@RequestParam("receiver") Long idReceiver, @RequestParam("value") BigDecimal value){
        var payerUser = userRepository.getReferenceById(idPayer);
        var receiverUser = userRepository.getReferenceById(idReceiver);

        transactionService.trasaction(payerUser,receiverUser, value);

        return ResponseEntity.ok(new DTOTransaction(payerUser,receiverUser,value));
    }

}
