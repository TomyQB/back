package com.appuntate.back.security.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.appuntate.back.model.EventUser;
import com.appuntate.back.model.History;
import com.appuntate.back.model.Reservation;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @NotNull
    private String phone;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String userName;
    
    private String creditCard;
    private String image;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Reservation> reservations;
    
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<History> histories;

    @OneToMany(mappedBy = "user")
    private List<EventUser> eventUser;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_rol",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn (name = "rol_id"))
    private List<Rol> rols;

    
}
