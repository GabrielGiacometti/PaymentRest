package com.giacometti.gabriel.payMentRestApi.model.user;

import com.giacometti.gabriel.payMentRestApi.DTO.user.UserDataSaveDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Table(name ="users")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String email;
    private String senha;
    @Enumerated(EnumType.STRING)
    private UserTypeEnum type;
    private BigDecimal balance;


    public User (UserDataSaveDto data){
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.email = data.email();
        this.senha = data.senha();
        this.type = data.type();
        this.balance = data.balance();
    }

}
