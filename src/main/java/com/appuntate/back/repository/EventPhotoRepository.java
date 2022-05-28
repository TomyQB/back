package com.appuntate.back.repository;

import com.appuntate.back.model.EventPhoto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventPhotoRepository extends JpaRepository<EventPhoto, String> {
    
}
