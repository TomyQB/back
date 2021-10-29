package com.appuntate.back.repository;

import com.appuntate.back.model.Center;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CenterRepository extends JpaRepository<Center, Long>, JpaSpecificationExecutor<Center> {
    
}
