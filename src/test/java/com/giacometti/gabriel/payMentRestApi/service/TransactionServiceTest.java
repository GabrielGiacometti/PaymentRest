package com.giacometti.gabriel.payMentRestApi.service;

import com.giacometti.gabriel.payMentRestApi.DTO.transaction.MakeTransactionDto;
import com.giacometti.gabriel.payMentRestApi.model.transaction.Transaction;
import com.giacometti.gabriel.payMentRestApi.model.user.User;
import com.giacometti.gabriel.payMentRestApi.model.user.UserRepository;
import com.giacometti.gabriel.payMentRestApi.model.user.UserTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @Mock
    private User payer;
    @Mock
    private User receiver;
    @Mock
    private UserRepository userRepository;
    @Mock
    private Transaction transaction;
    @Mock
    private MakeTransactionDto makeTransactionDto;

    @InjectMocks
    private TransactionService transactionService;


    @Test
    void dontMakeTrasanctionWithShopkeeperLikePayer(){
        //ARRANGE
        BDDMockito.given(userRepository.getReferenceById(makeTransactionDto.payer())).willReturn(payer);
            BDDMockito.given(payer.getType()).willReturn(UserTypeEnum.SHOPKEEPER);
        //ACT

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            transactionService.transaction(makeTransactionDto);
        });
        //ASSERT

        Assertions.assertEquals("SHOPKEEPER users can not make transactions", exception.getMessage());
    }

    @Test
    void dontMakeTrasanctionWithPayerWithoutMoney(){
        //ARRANGE
        BDDMockito.given(userRepository.getReferenceById(makeTransactionDto.payer())).willReturn(payer);
        BDDMockito.given(payer.getType()).willReturn(UserTypeEnum.SHOPKEEPER);
        BDDMockito.given(makeTransactionDto.value()).willReturn(new BigDecimal(500));
        BDDMockito.given(payer.getBalance()).willReturn(new BigDecimal(10));

        //ACT
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            transactionService.transaction(makeTransactionDto);
        });

        //ASSERT
        Assertions.assertEquals("Payer do not have enough money", exception.getMessage());

    }

    @Test
    void doTransactionWithValue100(){
        //ARRANGE / ACT
        transaction = new Transaction(payer,receiver,new BigDecimal(100));


        //ASSERT
        Assertions.assertEquals(transaction.getValue(),new BigDecimal(100));

    }


}