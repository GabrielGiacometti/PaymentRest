package com.giacometti.gabriel.payMentRestApi.DTO.email;

import com.giacometti.gabriel.payMentRestApi.model.email.Email;
import com.giacometti.gabriel.payMentRestApi.model.email.StatusEmail;

import java.time.LocalDateTime;

public record ListEmailDTO (Long emailId,
                            String sender,
                            String receiver,
                            String title,
                            LocalDateTime sendDateEmail,
                            StatusEmail statusEmail){

    public ListEmailDTO(Email email){
        this(email.getEmailId(), email.getSender(), email.getReceiver(), email.getTitle(), email.getSendDateEmail(), email.getStatusEmail());

    }
}
