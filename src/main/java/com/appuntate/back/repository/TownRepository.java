package com.appuntate.back.repository;

import com.appuntate.back.model.Town;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TownRepository extends JpaRepository<Town, Long>{
    
}
