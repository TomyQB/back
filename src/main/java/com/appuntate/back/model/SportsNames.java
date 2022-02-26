package com.appuntate.back.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "sport_name")
@Data
public class SportsNames {

    @Id
    private long id;

    private String name;
    private String photo;

    @OneToMany(mappedBy = "sportsNames")
    @JsonIgnore
    private List<Sport> sports;
    
}
