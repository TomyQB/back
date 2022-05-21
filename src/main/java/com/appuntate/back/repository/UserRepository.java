package com.appuntate.back.repository;

import com.appuntate.back.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserNameAndPassword(String email, String password);
 
    User findByEmail(String email);
    
    User findByUserIdAndPassword(long userId, String password);

}