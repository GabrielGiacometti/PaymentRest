package com.giacometti.gabriel.payMentRestApi.model.transaction;

import com.giacometti.gabriel.payMentRestApi.model.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "transactions")
@Entity
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payer")
    @NonNull
    private User payer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver")
    @NonNull
    private User receiver;

    @NonNull
    private BigDecimal value;

    @Column(columnDefinition = "TIMESTAMP")
    private final LocalDateTime date = LocalDateTime.now();
}
