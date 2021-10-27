package com.appuntate.back.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "USUARIO")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "dni")
    private long dni;

    private String name;
    private String lastName;
    private String phone;
    private String creditCard;
    private String email;
    private String password;
    private String image;
    private String userName;

    @OneToMany
    private List<Booking> bookings;
    
}
