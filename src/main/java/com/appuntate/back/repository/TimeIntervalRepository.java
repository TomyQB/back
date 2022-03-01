package com.appuntate.back.repository;

import java.util.List;

import com.appuntate.back.model.TimeInterval;
import com.appuntate.back.model.dto.timeInterval.TimeIntervalCenterDTO;
import com.appuntate.back.model.dto.timeInterval.TimeIntervalDTO;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface TimeIntervalRepository extends JpaRepository<TimeInterval, Long> {

    TimeInterval findByStartHourAndEndHour(int startHour, int endHour);
    
    List<TimeInterval> findByReservationCourtCourtIdAndReservationDate(long courtId, String date);

    // @Query("select * from TimeInterval t where t.court =" +
    //         " (select c.courtId from Court c where c.sport =" +
    //         " (select s.sportId from Sport c where s.center =" +
    //         " (select ce.centerId from Center ce where ce.centerId = :centerId)))" +
    //         " group by t.startHour")

//     @Query("select new com.appuntate.back.model.TimeIntervalCenterDTO(t.startHour) from TimeInterval t, Court c, Sport c, Center ce" +
//             " where t.court = c.courtId and c.sport = s.sportId and s.center = :centerId group by t.startHour")
//     List<TimeIntervalCenterDTO> findDistinctByCourtSportCenterCenterId(@Param("centerId") long centerId);
}
