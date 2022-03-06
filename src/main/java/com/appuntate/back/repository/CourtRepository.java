package com.appuntate.back.repository;

import java.util.List;

import com.appuntate.back.model.Court;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourtRepository extends JpaRepository<Court, Long>, JpaSpecificationExecutor<Court> {
    
}
