package com.appuntate.back.service;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.model.TimeInterval;
import com.appuntate.back.model.dto.CourtDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeIntervalService {

    public List<TimeInterval> createTimeIntervalByHours(String startHour, String endHour, String interval) {
        List<TimeInterval> timeIntervals = new ArrayList<>();

        int startHourInt = HourConverter.stringToHour(startHour);
        int endHourInt = HourConverter.stringToHour(endHour);
        int intervalInt = HourConverter.stringToHour(interval);

        while(startHourInt < endHourInt) {
            TimeInterval timeInterval = new TimeInterval();

            timeInterval.setStartHour(startHourInt);

            int auxEnHour = calculateEndHour(startHourInt, intervalInt);
            timeInterval.setEndHour(auxEnHour);

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
