package com.appuntate.back.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "COURT")
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codCourt;

    private String name;
    
    @ManyToOne
    @JoinColumn(name = "cod_sport")
    private Sport sport;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TimeInterval> timeIntervals;
    
}
