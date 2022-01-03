package com.appuntate.back.repository;

import com.appuntate.back.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailAndPasswordAndIsAdmin(String email, String password, boolean isAdmin);
 
    User findByEmail(String email);

}