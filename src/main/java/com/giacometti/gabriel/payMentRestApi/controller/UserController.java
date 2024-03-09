package com.giacometti.gabriel.payMentRestApi.controller;

import com.giacometti.gabriel.payMentRestApi.DTO.user.ListUserDto;
import com.giacometti.gabriel.payMentRestApi.DTO.user.UserDataSaveDto;
import com.giacometti.gabriel.payMentRestApi.model.user.User;
import com.giacometti.gabriel.payMentRestApi.DTO.user.UserDetailResponseDto;
import com.giacometti.gabriel.payMentRestApi.model.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity saveUser(@RequestBody @Valid UserDataSaveDto data, UriComponentsBuilder uriBuilder){
        var user = new User(data);
        userRepository.save(user);
        var uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDetailResponseDto(user));
    }

    @GetMapping
    public ResponseEntity<Page> list(@PageableDefault(size= 10) Pageable pageable) {
        var page = userRepository.findAll(pageable).map(ListUserDto::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity detailUser(@PathVariable  Long id){
        var user = userRepository.getReferenceById(id);

        return ResponseEntity.ok(new UserDetailResponseDto(user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        var user = userRepository.getReferenceById(id);
        userRepository.delete(user);
        return ResponseEntity.ok(new UserDetailResponseDto(user));
    }

}
