package com.appuntate.back.service;

import com.appuntate.back.model.Event;
import com.appuntate.back.model.EventPhoto;
import com.appuntate.back.repository.EventPhotoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventPhotoService {

    @Autowired
    private EventPhotoRepository eventPhotoRepository;

    public void deleteEventPhotoByKey(String publicKey) {
        eventPhotoRepository.deleteById(publicKey);
    }
    
    public void setEventToEventPhoto(Event event) {
        event.getPhoto().setEvent(event);
    }
}
