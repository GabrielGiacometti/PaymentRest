package com.giacometti.gabriel.payMentRestApi.model.user;


import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

        User findAllByid(Long id);
}
