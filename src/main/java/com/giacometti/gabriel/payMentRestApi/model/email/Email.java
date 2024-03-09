package com.giacometti.gabriel.payMentRestApi.model.email;


import com.giacometti.gabriel.payMentRestApi.model.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDateTime;


@Table(name = "emails")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emailId;


    @jakarta.validation.constraints.Email
    private String sender = "gabrielhdfg460@gmail.com";

    @NotBlank
    @jakarta.validation.constraints.Email
    private String receiver;


    @Column(columnDefinition = "TEXT")
    @NotBlank
    private String text;

    @NotBlank
    private String title;

    @NotNull
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;


    public Email(String receiver){
        this.receiver = receiver;

    }

    public Email setEmailToPayer(BigDecimal value,String receiver){
        this.title = "PAGAMENTO EFETUADO";

        this.text= String.format("O pagamento no valor de : %f foi efetuado%n" +
                "Email da conta recebida : %s",value,receiver);
        return this;
    }

    public Email setEmailToReceiver(BigDecimal value,String sender){
        this.title = "PAGAMENTO RECEBIDO";

        this.text= String.format("O pagamento no valor de : %f foi efetuado%n" +
                "Email do pagador : %s",value,sender);

        return this;
    }
}
