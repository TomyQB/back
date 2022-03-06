package com.appuntate.back.repository;

import java.util.List;

import com.appuntate.back.model.TimeInterval;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TimeIntervalRepository extends JpaRepository<TimeInterval, Long> {

    TimeInterval findByStartHourAndEndHour(int startHour, int endHour);
    

    List<TimeInterval> findReservedTimeIntervalByCourtCourtIdAndReservationDate(@Param("courtId") long courtId, @Param("date") String date);

    List<TimeInterval> findNotReservedByCourtCourtIdAndTimeIntervalIdNotIn(long courtId, List<Long> timeIntervals);

    List<TimeInterval> findNotReservedByCourtCourtId(long courtId);
    
    @Query("select distinct t.startHour from TimeInterval t, Court c, Sport s where t.court = c.courtId and c.sport = s.sportId and s.center.centerId = :centerId and" +
            " t.startHour > :startHour and t.timeIntervalId not in (select r.timeInterval from Reservation r, Court c, Sport s" +
            " where r.date = :date and r.court = c.courtId and c.sport = s.sportId and s.center.centerId = :centerId)")
    List<Integer> findAllByCourtCourtIdAndReservationDateAndStartHour(@Param("centerId") long centerId, @Param("date") String date, @Param("startHour") int startHour);

    @Query("select t from TimeInterval t where t.court.courtId = :courtId and t.timeIntervalId not in (select r.timeInterval from Reservation r where r.court = :courtId and r.date = :date)")
    List<TimeInterval> findAllByCourtCourtIdAndReservationDate(@Param("courtId") long courtId, @Param("date") String date);

    
    @Query("select distinct t from TimeInterval t, Court c, Sport s where t.court = c.courtId and c.sport = s.sportId and s.center.centerId = :centerId and" +
    " t.startHour = :startHour and t.timeIntervalId not in (select r.timeInterval from Reservation r, Court c, Sport s" +
    " where r.date = :date and r.court = c.courtId and c.sport = s.sportId and s.center.centerId = :centerId)")
    List<TimeInterval> findFirstByCourtCourtIdAndReservationDateAndStartHour(@Param("centerId") long centerId, @Param("date") String date, @Param("startHour") int startHour);


}
