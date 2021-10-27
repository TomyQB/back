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

import lombok.Data;


@Entity
@Data
@Table(name = "CENTER")
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codCenter;

    private String adress;
    private String startHour;
    private String endHour;
    
    @ManyToOne
    @JoinColumn(name = "cod_townHall")
    private TownHall townHall;

    @OneToMany
    private List<Sport> sports;

    @OneToMany
    private List<Festive> festives;
    
}
