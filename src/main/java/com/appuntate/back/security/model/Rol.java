package com.appuntate.back.security.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.appuntate.back.security.enums.RolName;

import lombok.Data;

@Entity
@Data
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long rolId;

    @Enumerated(EnumType.STRING)
    private RolName rolName;

    
}
