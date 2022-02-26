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
@Table(name = "festive")
public class Festive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long festiveId;

    private String day;
    private String month;
    private String year;

    @ManyToOne
    @JoinColumn(name = "centerId")
    private Center center;
    
}
