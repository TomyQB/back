package com.appuntate.back.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
@Table(name = "sport")
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sportId;
    
    @ManyToOne
    @JoinColumn(name = "centerId")
    @JsonIgnore
    private Center center;

    @OneToMany(mappedBy = "sport")
    private List<Court> courts;
    
    @OneToMany(mappedBy = "sport")
    private List<Event> events;

    @ManyToOne
    @JoinColumn(name = "sportNameId")
    private SportsNames sportName;

}
