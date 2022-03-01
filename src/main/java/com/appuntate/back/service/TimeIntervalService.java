package com.appuntate.back.service;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.mapper.timeInterval.TimeIntervalMapper;
import com.appuntate.back.model.Court;
import com.appuntate.back.model.TimeInterval;
import com.appuntate.back.model.dto.court.CourtSaveDTO;
import com.appuntate.back.model.dto.timeInterval.TimeIntervalCenterDTO;
import com.appuntate.back.model.dto.timeInterval.TimeIntervalDTO;
import com.appuntate.back.repository.TimeIntervalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeIntervalService {

    @Autowired
    private TimeIntervalRepository timeIntervalRepository;

    @Autowired
    private TimeIntervalMapper timeIntervalMapper;

    public TimeInterval getTimeIntervalByCodTimeInterval(long timeIntervalId) {
        return timeIntervalRepository.getById(timeIntervalId);
    }

    public List<TimeInterval> getTimeIntervalsReservedByCourtId(long courtId, String date) {
        return timeIntervalRepository.findByReservationCourtCourtIdAndReservationDate(courtId, date);
    }

    // public List<TimeIntervalCenterDTO> getDistinctTimeIntervalsByCenter(long centerId) {
    //     return timeIntervalRepository.findDistinctByCourtSportCenterCenterId(centerId);
    // }

    public void setCourtToTimeInterval(Court court) {
        for (TimeInterval timeInterval : court.getTimeIntervals()) {
            timeInterval.setCourt(court);
        }
    }

    public List<TimeInterval> createTimeIntervalByHours(CourtSaveDTO dto, Court court) {
        List<TimeInterval> timeIntervals = new ArrayList<>();

        int startHourInt = HourConverter.stringToHour(dto.getStartHour());
        int endHourInt = HourConverter.stringToHour(dto.getEndHour());
        int intervalInt = HourConverter.stringToHour(dto.getDuration());

        while(startHourInt < endHourInt) {
            int auxEnHour = calculateEndHour(startHourInt, intervalInt);
            // TimeInterval timeInterval = timeIntervalRepository.findByStartHourAndEndHour(startHourInt, auxEnHour);
            TimeInterval timeInterval = new TimeInterval(startHourInt, auxEnHour, court);

            if(/*timeInterval != null &&*/ timeInterval.getEndHour() < endHourInt)
                timeIntervals.add(timeInterval);

            startHourInt = auxEnHour;
        }

        return timeIntervals;
    }

    private int calculateEndHour(int startHourInt, int intervalInt) {

        int res = 0;

        if(isHalfHour(startHourInt)) res = startHourInt + 170;
        else res = startHourInt + intervalInt;

        return res;
    }

    private boolean isHalfHour(int startHourInt) {
        String hour = Integer.toString(startHourInt);
        return hour.charAt(hour.length() - 2) == "3".charAt(0);
    }
    
}
