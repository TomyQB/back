package com.appuntate.back.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "town")
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codTown;

    private String name;

    @ManyToOne
    @JoinColumn(name = "cod_city")
    private City city;
    
}
