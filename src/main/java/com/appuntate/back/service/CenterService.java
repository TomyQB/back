package com.appuntate.back.service;

import java.util.List;

import com.appuntate.back.model.Center;
import com.appuntate.back.model.Court;
import com.appuntate.back.model.Sport;
import com.appuntate.back.model.TimeInterval;
import com.appuntate.back.model.criteria.CenterCriteria;
import com.appuntate.back.model.dto.CenterFilterDTO;
import com.appuntate.back.repository.CenterRepository;
import com.appuntate.back.service.criteria.CenterCriteriaService;
import com.appuntate.back.service.specification.CenterSpecificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CenterService {
    
    @Autowired
    private CenterRepository centerRepository;
    
    @Autowired
    private CenterCriteriaService centerCriteriaService;

    @Autowired
    private CenterSpecificationService centerSpecificationService;

    @Autowired
    private TimeIntervalService timeIntervalService;

    public Center getCenterById(long centerId) {
        return centerRepository.getById(centerId);
    }

    public Center getCenterByCodCourt(long codCourt) {
        return centerRepository.findBySportsCourtsCodCourt(codCourt);
    }

    public List<Center> getCentersByFilters(CenterFilterDTO centerFilterDTO) {
        CenterCriteria centerCriteria = centerCriteriaService.createCriteria(centerFilterDTO);
        List<Center> centers = centerRepository.findAll(centerSpecificationService.createSpecification(centerCriteria));

        if(centerFilterDTO.getSport() != null)
            centers = deleteNoInterestedSports(centers, centerFilterDTO.getSport());

        centers = deleteNotInterestedHours(centers, centerFilterDTO);
        return deleteReserveddHours(centers, centerFilterDTO);
    }

    private List<Center> deleteNoInterestedSports(List<Center> centers, String sportName) {

        for (Center center : centers) {
            center.getSports().removeIf(s -> !s.getSportsNames().getName().equals(sportName));       
        }
        return centers;
    }

    private List<Center> deleteNotInterestedHours(List<Center> centers, CenterFilterDTO centerFilterDTO) {
        
        for (Center center : centers) {
            for (Sport sport : center.getSports()) {
                for (Court court : sport.getCourts()) {
                    if(centerFilterDTO.getHour() != null)
                        court.getTimeIntervals().removeIf(t -> t.getStartHour() < HourConverter.stringToHour(centerFilterDTO.getHour()));                    
                }
            }
        }

        return centers;
    }

    private List<Center> deleteReserveddHours(List<Center> centers, CenterFilterDTO centerFilterDTO) {
        
        for (Center center : centers) {
            for (Court court : center.getSports().get(0).getCourts()) {
                List<TimeInterval> timeIntervals = timeIntervalService.getTimeIntervalsReservedByCourtId(court.getCodCourt(), centerFilterDTO.getDate());
                for (TimeInterval timeInterval : timeIntervals) {
                    court.getTimeIntervals().removeIf(t -> t.getStartHour() == timeInterval.getStartHour());
                }
            }
        }

        return centers;

    }
    
}
