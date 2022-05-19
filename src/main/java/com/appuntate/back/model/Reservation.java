package com.appuntate.back.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.appuntate.back.security.model.User;

import lombok.Data;


@Entity
@Data
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reservationId;

    private String date;
    private boolean paid;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "courtId")
    private Court court;

    @ManyToOne
    @JoinColumn(name = "timeintervalId")
    private TimeInterval timeInterval;

    
}
