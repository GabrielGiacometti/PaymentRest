package com.giacometti.gabriel.payMentRestApi.controller;

import com.giacometti.gabriel.payMentRestApi.DTO.user.ListUserDto;
import com.giacometti.gabriel.payMentRestApi.DTO.user.UserDataSaveDto;
import com.giacometti.gabriel.payMentRestApi.model.user.User;
import com.giacometti.gabriel.payMentRestApi.DTO.user.UserDetailResponseDto;
import com.giacometti.gabriel.payMentRestApi.model.user.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name= "Users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Operation(summary = "Save a user")
    @PostMapping
    @Transactional
    public ResponseEntity saveUser(@RequestBody @Valid UserDataSaveDto data, UriComponentsBuilder uriBuilder){
        var user = new User(data);
        userRepository.save(user);
        var uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDetailResponseDto(user));
    }

    @Operation(summary = "Get all users")
    @GetMapping
    @Parameter(name = "sort", schema = @Schema(type = "string", defaultValue = "id"))
    public ResponseEntity<Page> list(@PageableDefault(size= 10) Pageable pageable) {
        var page = userRepository.findAll(pageable).map(ListUserDto::new);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "Get a specific user by ID")
    @GetMapping("/{id}")
    public ResponseEntity detailUser(@PathVariable  Long id){
        var user = userRepository.getReferenceById(id);

        return ResponseEntity.ok(new UserDetailResponseDto(user));
    }
    @Operation(summary = "Delete a user by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        var user = userRepository.getReferenceById(id);
        userRepository.delete(user);
        return ResponseEntity.ok(new UserDetailResponseDto(user));
    }

}
