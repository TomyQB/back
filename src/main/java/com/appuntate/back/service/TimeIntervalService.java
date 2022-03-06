package com.appuntate.back.service;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.forbidden.NotAvailableReservationForbiddenException;
import com.appuntate.back.mapper.timeInterval.TimeIntervalMapper;
import com.appuntate.back.model.Court;
import com.appuntate.back.model.TimeInterval;
import com.appuntate.back.model.dto.court.CourtSaveDTO;
import com.appuntate.back.repository.TimeIntervalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeIntervalService {

    @Autowired
    private TimeIntervalRepository timeIntervalRepository;


    public TimeInterval getTimeIntervalById(long timeIntervalId) {
        return timeIntervalRepository.getById(timeIntervalId);
    }
    
    public List<String> getInterestedTimeIntervals (long centerId, String date, int startHour) {
        return HourConverter.listHourToListString(timeIntervalRepository.findAllByCourtCourtIdAndReservationDateAndStartHour(centerId, date, startHour));
    }

    public List<TimeInterval> getNotReservedTimeIntervals (long courtId, String date) {
        return timeIntervalRepository.findAllByCourtCourtIdAndReservationDate(courtId, date);
    }
    
    public List<TimeInterval> getTimeIntervalByCenterIdAndAvailableHour(long centerId, String hour, String date) {
        return timeIntervalRepository.findFirstByCourtCourtIdAndReservationDateAndStartHour(centerId, date, HourConverter.stringToHour(hour));
    }

    public TimeInterval getTimeIntervalByCourtIdAndHour(long courtId, String hour) {
        return timeIntervalRepository.findByCourtCourtIdAndStartHour(courtId, HourConverter.stringToHour(hour));
    }

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
            TimeInterval timeInterval = new TimeInterval(startHourInt, auxEnHour, court);

            if(timeInterval.getEndHour() < endHourInt)
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
