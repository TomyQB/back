package com.appuntate.back.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "FESTIVE")
public class Festive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codFestive;

    private String day;
    private String month;
    private String year;
    
}
