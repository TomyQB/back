package com.appuntate.back.model;

import java.util.ArrayList;
import java.util.List;

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
@Data
@Table(name = "timeinterval")
public class TimeInterval {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codTimeInterval;

    private int startHour;
    private int endHour;

    @OneToMany(mappedBy = "timeInterval")
    @JsonIgnore
    private List<Booking> booking;

    @JoinTable(
        name = "timeinterval_court",
        joinColumns = @JoinColumn(name = "cod_timeinterval"),
        inverseJoinColumns = @JoinColumn(name = "cod_court")
    )
    @ManyToMany
    @JsonIgnore
    private List<Court> courts;

    public void addCourt(Court court){
        if(courts == null){
            courts = new ArrayList<>();
        }
        
        courts.add(court);
    }
    
}