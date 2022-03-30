package com.appuntate.back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(EventUserIds.class)
@Table(name = "event_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventUser {

    @Id
    @Column(name = "event_ref")
    private long eventId;

    @Id
    @Column(name = "user_ref")
    private long userId;
    
    @ManyToOne
    @JsonIgnore
    private Event event;

    @ManyToOne
    @JsonIgnore
    private User user;
 
}
