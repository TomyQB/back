package com.appuntate.back.service;

import com.appuntate.back.model.Event;
import com.appuntate.back.model.EventPhoto;

import org.springframework.stereotype.Service;

@Service
public class EventPhotoService {
    
    public void setEventToEventPhoto(Event event) {
        for (EventPhoto eventPhoto : event.getPhotos()) {
            eventPhoto.setEvent(event);
        }
    }
}
