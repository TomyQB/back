package com.appuntate.back.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @JoinColumn(name = "dni")
    private long codUsuario;

    private String name;
    private String lastName;
    private String phone;
    private String creditCard;
    private String email;
    private String password;
    private String image;
    private String userName;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Booking> bookings;
    
}