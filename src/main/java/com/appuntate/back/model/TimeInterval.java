package com.appuntate.back.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "timeinterval")
public class TimeInterval {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long timeIntervalId;

    private int startHour;
    private int endHour;

    @OneToMany(mappedBy = "timeInterval")
    @JsonIgnore
    private List<Reservation> reservation;

    @ManyToOne
    @JoinColumn(name = "court")
    @JsonIgnore
    private Court court;

    public TimeInterval(int startHour, int endHour, Court court) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.court = court;
    }
    
}
