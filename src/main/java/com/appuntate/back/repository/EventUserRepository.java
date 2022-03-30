package com.appuntate.back.repository;

import com.appuntate.back.model.EventUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventUserRepository extends JpaRepository<EventUser, Long>{

    EventUser findByEventIdAndUserId(long eventId, long userId);

    void deleteByEventIdAndUserId(long eventId, long userId);
    
}
