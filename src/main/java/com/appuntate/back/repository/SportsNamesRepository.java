package com.appuntate.back.repository;

import com.appuntate.back.model.SportsNames;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsNamesRepository extends JpaRepository<SportsNames, Long> {
    
}
