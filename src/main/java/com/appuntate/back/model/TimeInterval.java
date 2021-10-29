package com.appuntate.back.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "TIMEINTERVAL")
public class TimeInterval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codTimeInterval;

    private int startHour;
    private int endHour;

    @OneToMany
    private List<Booking> booking;
    
}
