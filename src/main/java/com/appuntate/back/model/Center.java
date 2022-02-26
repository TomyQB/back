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
@Table(name = "center")
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long centerId;

    private String name;
    private String adress;
    private int startHour;
    private int endHour;
    private String image;

    @OneToMany(mappedBy = "center")
    private List<Sport> sports;

    @OneToMany(mappedBy = "center")
    private List<Festive> festives;
    
}
