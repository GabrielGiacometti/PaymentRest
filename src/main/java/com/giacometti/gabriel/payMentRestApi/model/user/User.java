package com.giacometti.gabriel.payMentRestApi.model.user;

import com.giacometti.gabriel.payMentRestApi.model.user.UserTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Table(name ="users")
@Setter
@Getter
@Entity(name = "User")
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
    private BigInteger balance;


    public User (DataUserSave data){
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.email = data.email();
        this.senha = data.senha();
        this.type = data.type();
        this.balance = data.balance();
    }

}
