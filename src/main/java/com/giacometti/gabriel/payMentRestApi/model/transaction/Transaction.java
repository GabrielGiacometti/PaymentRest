package com.giacometti.gabriel.payMentRestApi.model.transaction;

import com.giacometti.gabriel.payMentRestApi.model.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "transactions")
@Entity(name ="Transaction")
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "payer")
    private User payer;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "receiver")
    private User receiver;

    @NonNull
    private BigDecimal value;

    @Column(columnDefinition = "TIMESTAMP")
    private final LocalDateTime date = LocalDateTime.now();
}
