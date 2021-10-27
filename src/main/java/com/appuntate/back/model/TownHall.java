package com.appuntate.back.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "TOWNHALL")
public class TownHall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codTownHall;

    private String name;
    private String adress;
    private String CP;
    private String inscriptionDate;
    private boolean isActive;

    @OneToOne
    @JoinColumn(name = "cod_town")
    private Town town;

    @OneToMany
    private List<Center> centers;
    
}
