package com.appuntate.back.repository;

import java.util.List;

import com.appuntate.back.model.Court;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CourtRepository extends JpaRepository<Court, Long>, JpaSpecificationExecutor<Court> {
    
}
