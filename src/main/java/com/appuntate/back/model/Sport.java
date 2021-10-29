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
@Table(name = "SPORT")
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codSport;

    private String name;
    
    @ManyToOne
    @JoinColumn(name = "cod_center")
    @JsonIgnore
    private Center center;

    @OneToMany
    private List<Court> courts;

}
