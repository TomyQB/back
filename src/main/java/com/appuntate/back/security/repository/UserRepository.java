package com.appuntate.back.security.repository;

import com.appuntate.back.security.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);

    User findByUserIdAndPassword(long userId, String password);

}