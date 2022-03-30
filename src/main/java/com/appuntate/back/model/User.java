package com.appuntate.back.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    private String name;
    private String lastName;
    private String phone;
    private String creditCard;
    private String email;
    private String password;
    private String image;
    private String userName;
    private String admin;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "user")
    private List<EventUser> eventUser;

    // @ManyToMany(mappedBy = "users", cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    // private List<Event> events;
    
}
