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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
@Table(name = "townhall")
public class TownHall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codTownHall;

    private String name;
    private String adress;
    private String CP;
    private String inscriptionDate;
    private boolean isActive;

    @OneToOne
    @JoinColumn(name = "cod_town")
    private Town town;

    @OneToMany(mappedBy = "townHall")
    @JsonIgnore
    private List<Center> centers;
    
}
