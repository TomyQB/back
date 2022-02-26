package com.appuntate.back.repository;

import java.util.List;

import com.appuntate.back.model.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    
    Reservation findByCourtCourtIdAndDateAndTimeIntervalTimeIntervalId(long courtId, String date, long timeIntervalId);

    List<Reservation> findByUserUserId(long userId);

    List<Reservation> findByCourtSportCenterCenterId(long centerId);

    Reservation deleteById(long reservationId);
}
