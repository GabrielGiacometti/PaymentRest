package com.giacometti.gabriel.payMentRestApi.model.transaction;

import com.giacometti.gabriel.payMentRestApi.DTO.DTOResponseTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
