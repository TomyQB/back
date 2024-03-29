package com.appuntate.back.repository;

import java.util.List;

import com.appuntate.back.model.TimeInterval;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TimeIntervalRepository extends JpaRepository<TimeInterval, Long> {

    TimeInterval findByCourtCourtIdAndStartHour(long courtId, int hour);

    @Query("select distinct t.startHour from TimeInterval t, Court c, Sport s, SportsNames sn where t.court = c.courtId and c.sport = s.sportId and s.sportName = sn.id and" +
            " sn.name = :sport and s.center.centerId = :centerId and t.startHour > :startHour and t.timeIntervalId not in" +
            " (select r.timeInterval from Reservation r, Court c, Sport s" +
            " where r.date = :date and r.court = c.courtId and c.sport = s.sportId and s.center.centerId = :centerId)")
    List<Integer> findAllByCourtCourtIdAndCourtNameAndReservationDateAndStartHour(@Param("centerId") long centerId, @Param("sport") String sport, @Param("date") String date, @Param("startHour") int startHour);

    @Query("select t from TimeInterval t where t.court.courtId = :courtId and t.timeIntervalId not in (select r.timeInterval from Reservation r where r.court = :courtId and r.date = :date)")
    List<TimeInterval> findAllByCourtCourtIdAndReservationDate(@Param("courtId") long courtId, @Param("date") String date);
    
    @Query("select t from TimeInterval t where t.court.courtId = :courtId and t.startHour >= :startHour and t.timeIntervalId not in (select r.timeInterval from Reservation r where r.court = :courtId and r.date = :date)")
    List<TimeInterval> findAllByCourtCourtIdAndReservationDateAndStartHour(@Param("courtId") long courtId, @Param("date") String date, @Param("startHour") int startHour);

    @Query("select distinct t from TimeInterval t, Court c, Sport s where t.court = c.courtId and c.sport = s.sportId and s.center.centerId = :centerId and" +
    " t.startHour = :startHour and t.timeIntervalId not in (select r.timeInterval from Reservation r, Court c, Sport s" +
    " where r.date = :date and r.court = c.courtId and c.sport = s.sportId and s.center.centerId = :centerId)")
    List<TimeInterval> findByCourtCourtIdAndReservationDateAndStartHour(@Param("centerId") long centerId, @Param("date") String date, @Param("startHour") int startHour);
    
    @Query("select distinct t from TimeInterval t, Court c, Sport s, SportsNames sn where t.court = c.courtId and c.sport = s.sportId and s.sportName = sn.id" +
    " and sn.name = :sport and s.center.centerId = :centerId and t.startHour = :startHour and t.timeIntervalId not in" +
    " (select r.timeInterval from Reservation r, Court c, Sport s" +
    " where r.date = :date and r.court = c.courtId and c.sport = s.sportId and s.center.centerId = :centerId)")
    List<TimeInterval> findByCourtCourtIdAndCourtNameAndReservationDateAndStartHour(@Param("centerId") long centerId, @Param("sport") String sport, @Param("date") String date, @Param("startHour") int startHour);


    // @Query("select t from TimeInterval t, Court c where t.court.courtId = :courtId and" +
    // " t.startHour = :startHour and t.timeIntervalId not in (select r.timeInterval from Reservation r, Court c" +
    // " where r.date = :date and r.court.courtId = :courtId)")
    // TimeInterval findByTimeIntervalIdAndReservationDateAndStartHour(@Param("courtId") long courtId, @Param("date") String date, @Param("startHour") int startHour);


}
