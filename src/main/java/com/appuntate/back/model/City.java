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
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codCity;

    private String name;

    @ManyToOne
    @JoinColumn(name = "cod_country")
    private Country country;

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<Town> towns;
    
}
