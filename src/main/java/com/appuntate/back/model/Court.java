package com.appuntate.back.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
@Table(name = "court")
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long courtId;

    private String name;
    private int interval;
    private double price;
    private double valoration;
    
    @ManyToOne
    @JoinColumn(name = "sportId")
    @JsonIgnore
    private Sport sport;

    @OneToMany(mappedBy = "court")
    @JsonIgnore
    private List<Reservation> reservations;
    
    @OneToMany(mappedBy = "court", cascade = CascadeType.ALL)
    private List<TimeInterval> timeIntervals;
    
}
