package com.appuntate.back.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private Double price;
    private int competitorAmount;
    
    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
    private EventPhoto photo;

    @ManyToOne
    @JoinColumn(name = "sportId")
    @JsonIgnore
    private Sport sport;
    
    @OneToMany(mappedBy = "event")
    private List<EventUser> eventUser;

    // @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    // @JoinTable(name = "eventUser", 
    //     joinColumns = @JoinColumn(name = "eventId"), 
    //     inverseJoinColumns = @JoinColumn(name = "userId"))
    // @JsonIgnore
    // private List<User> users;

    // public void removeUser(User user) {
    //     users.remove(user);
    //     user.getEvents().remove(this);
    // }

}
