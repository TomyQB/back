package com.appuntate.back.repository;

import java.util.List;


import com.appuntate.back.model.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {

    List<Event> findByEventUserUserId(long userId);
    
    List<Event> findBySportCenterCenterId(long centerId);
    
}
