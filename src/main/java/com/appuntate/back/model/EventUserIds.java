package com.appuntate.back.model;

import java.io.Serializable;

public class EventUserIds implements Serializable {

    private long eventId;
    private long userId;

    public EventUserIds(long eventId, long userId) {
        this.eventId = eventId;
        this.userId = userId;
    }

    public EventUserIds() {}
    
}
