package com.appuntate.back.repository;

import java.util.List;

import com.appuntate.back.model.TimeInterval;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeIntervalRepository extends JpaRepository<TimeInterval, Long> {
    
    List<TimeInterval> findByCourtCodCourtAndBookingDate(long codCourt, String date);
}
