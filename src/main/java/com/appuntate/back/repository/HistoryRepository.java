package com.appuntate.back.repository;

import java.util.List;

import com.appuntate.back.model.History;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {

    List<History> findByUserUserIdOrderByDateAsc(long userId);
    
}
