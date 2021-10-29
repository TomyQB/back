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
@Table(name = "BOOKING")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codBooking;

    private String date;
    private String bookingDate;
    private boolean paid;

    @ManyToOne
    @JoinColumn(name = "DNI_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "cod_timeInterval")
    private TimeInterval timeInterval;
    
}
