package com.appuntate.back.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codCountry;

    private String name;

    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<City> cities;
    
}
