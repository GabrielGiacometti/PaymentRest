package com.giacometti.gabriel.payMentRestApi.controller;

import com.giacometti.gabriel.payMentRestApi.model.user.UserDataSave;
import com.giacometti.gabriel.payMentRestApi.model.user.User;
import com.giacometti.gabriel.payMentRestApi.model.user.UserDetailResponse;
import com.giacometti.gabriel.payMentRestApi.model.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public ResponseEntity saveUser(@RequestBody @Valid UserDataSave data, UriComponentsBuilder uriBuilder){
        var user = new User(data);
        userRepository.save(user);
        var uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDetailResponse(user));
    }
    @GetMapping("/{id}")
    public ResponseEntity detailUser(@PathVariable  Long id){
        var user = userRepository.getReferenceById(id);

        return ResponseEntity.ok(new UserDetailResponse(user));
    }

}
