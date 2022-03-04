package com.appuntate.back.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "event")
@Data
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long eventId;

    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private int startHour;
    private int endHour;
    private String photo;
    private Double price;
    private int competitorAmount;

    @ManyToOne
    @JoinColumn(name = "centerId")
    private Center center;

    @ManyToMany
    @JoinTable(name = "eventUser", 
        joinColumns = @JoinColumn(name = "userId"), 
        inverseJoinColumns = @JoinColumn(name = "eventId"))
    private List<User> users;

}
