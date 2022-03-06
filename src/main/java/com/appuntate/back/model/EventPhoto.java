package com.appuntate.back.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "eventPhoto")
@Data
public class EventPhoto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long eventPhotoId;
    
    private String photo;

    @ManyToOne
    @JoinColumn(name = "event")
    @JsonIgnore
    private Event event;
}
