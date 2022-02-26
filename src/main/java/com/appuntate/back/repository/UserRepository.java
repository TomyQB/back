package com.appuntate.back.repository;

import com.appuntate.back.model.User;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserNameAndPasswordAndAdmin(String email, String password, String isAdmin);
 
    User findByEmail(String email);

}