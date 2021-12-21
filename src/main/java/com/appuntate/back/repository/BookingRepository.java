package com.appuntate.back.repository;

import java.util.List;

import com.appuntate.back.model.Booking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    
    Booking findByCourtCodCourtAndDateAndTimeIntervalCodTimeInterval(long codCourt, String date, long codTimeInterval);

    List<Booking> findByUserCodUsuario(long userId);

    List<Booking> findByCourtSportCenterCodCenter(long centerId);
}
