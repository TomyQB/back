package com.appuntate.back.service;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.model.Court;
import com.appuntate.back.model.TimeInterval;
import com.appuntate.back.model.dto.CourtDTO;
import com.appuntate.back.repository.TimeIntervalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeIntervalService {

    @Autowired
    private TimeIntervalRepository timeIntervalRepository;

    public List<TimeInterval> getTimeIntervalsReservedByCourtId(long courtId, String date) {
        return timeIntervalRepository.findByCourtsCodCourtAndBookingDate(courtId, date);
        // return null;
    }

    public void setCourtToTimeInterval(Court court) {
        for (TimeInterval timeInterval : court.getTimeIntervals()) {
            timeInterval.addCourt(court);
        }
    }

    public List<TimeInterval> saveTimeInterval(CourtDTO dto, Court court) {
        List<TimeInterval> timeIntervals = createTimeIntervalByHours(dto, court);

        if(!timeIntervals.isEmpty())
            timeIntervalRepository.saveAll(timeIntervals);

        return timeIntervals;
    }

    public List<TimeInterval> createTimeIntervalByHours(CourtDTO dto, Court court) {
        List<TimeInterval> timeIntervals = new ArrayList<>();

        int startHourInt = HourConverter.stringToHour(dto.getStartHour());
        int endHourInt = HourConverter.stringToHour(dto.getEndHour());
        int intervalInt = HourConverter.stringToHour(dto.getInterval());

        while(startHourInt < endHourInt) {
            int auxEnHour = calculateEndHour(startHourInt, intervalInt);
            TimeInterval timeInterval = timeIntervalRepository.findByStartHourAndEndHour(startHourInt, auxEnHour);

            // timeInterval.setStartHour(startHourInt);
            if(timeInterval != null && timeInterval.getEndHour() < endHourInt)
                timeIntervals.add(timeInterval);

            // int auxEnHour = calculateEndHour(startHourInt, intervalInt);
            // timeInterval.setEndHour(auxEnHour);

            // timeInterval.setCourt(court);

            // timeIntervals.add(timeInterval);

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
