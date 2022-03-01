package com.appuntate.back.service;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.notFound.CenterWithAvailableCourtsNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.CentersByFilterNotFoundException;
import com.appuntate.back.mapper.center.CenterResponseMapper;
import com.appuntate.back.mapper.timeInterval.TimeIntervalMapper;
import com.appuntate.back.model.Center;
import com.appuntate.back.model.Court;
import com.appuntate.back.model.TimeInterval;
import com.appuntate.back.model.criteria.CenterCriteria;
import com.appuntate.back.model.dto.center.CenterFilterDTO;
import com.appuntate.back.model.dto.center.CenterResponseDTO;
import com.appuntate.back.model.dto.timeInterval.TimeIntervalDTO;
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

    @Autowired
    private CenterResponseMapper centerResponseMapper;

    @Autowired
    private TimeIntervalMapper timeIntervalMapper;


    public Center getCenterById(long centerId) {
        return centerRepository.getById(centerId);
    }

    public Center getCenterByCodCourt(long courtId) {
        return centerRepository.findBySportsCourtsCourtId(courtId);
    }

    public List<CenterResponseDTO> getCentersByFilters(CenterFilterDTO centerFilterDTO) throws CentersByFilterNotFoundException, CenterWithAvailableCourtsNotFoundException {
        CenterCriteria centerCriteria = centerCriteriaService.createCriteria(centerFilterDTO);
        List<Center> centers = centerRepository.findAll(centerSpecificationService.createSpecification(centerCriteria));
        if(!centers.isEmpty()) return filterCenterQueryResult(centers, centerFilterDTO);
        throw new CentersByFilterNotFoundException();

    }

    private List<CenterResponseDTO> filterCenterQueryResult(List<Center> centers, CenterFilterDTO centerFilterDTO) throws CenterWithAvailableCourtsNotFoundException {
        List<CenterResponseDTO> centerResponseDTOs = new ArrayList<>();

        for(Center center : centers) {
            CenterResponseDTO centerDTO = centerResponseMapper.entityToDTO(center);
            centerDTO.setDistance(calculateDistanceWithLongLat(center, centerFilterDTO));
            centerDTO.setAvailableIntervals(getAvialableCenterIntervals(center, centerFilterDTO));
            if(!centerDTO.getAvailableIntervals().isEmpty())
                centerResponseDTOs.add(centerDTO);
        }

        if(!centerResponseDTOs.isEmpty()) return centerResponseDTOs;
        throw new CenterWithAvailableCourtsNotFoundException();
    }

    private double calculateDistanceWithLongLat(Center center, CenterFilterDTO centerFilterDTO) {
        double earthRadius = 6371; //km
        double dLat = Math.toRadians(center.getLatitude() - centerFilterDTO.getLatitude());  
        double dLng = Math.toRadians(center.getLongitude() - centerFilterDTO.getLongitude());  
        double sindLat = Math.sin(dLat / 2);  
        double sindLng = Math.sin(dLng / 2);  
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                * Math.cos(Math.toRadians(centerFilterDTO.getLatitude())) * Math.cos(Math.toRadians(center.getLatitude()));  
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
        double distance = earthRadius * va2;  
        distance = Math.round(distance * 10.0) / 10.0;

        return distance;  
    }

    private List<TimeIntervalDTO> getAvialableCenterIntervals(Center center, CenterFilterDTO centerFilterDTO) {
        List<TimeIntervalDTO> timeIntervalDTOs = new ArrayList<>();
        timeIntervalDTOs = deleteNotInterestedHours(center, centerFilterDTO, timeIntervalDTOs);
        // this.timeIntervalService.getDistinctTimeIntervalsByCenter(center.getCenterId());
        return timeIntervalDTOs;
    }

    private List<TimeIntervalDTO> deleteNotInterestedHours(Center center, CenterFilterDTO centerFilterDTO, List<TimeIntervalDTO> timeIntervalDTOs) {
        
        for (Court court : center.getSports().get(0).getCourts()) {
            if(centerFilterDTO.getHour() != null)
                court.getTimeIntervals().removeIf(t -> t.getStartHour() < HourConverter.stringToHour(centerFilterDTO.getHour()));
            
            timeIntervalDTOs = deleteReservedHours(court, centerFilterDTO, timeIntervalDTOs);
        }

        return timeIntervalDTOs;
    }

    private List<TimeIntervalDTO> deleteReservedHours(Court court, CenterFilterDTO centerFilterDTO, List<TimeIntervalDTO> timeIntervalDTOs) {
        List<TimeInterval> timeIntervals = timeIntervalService.getTimeIntervalsReservedByCourtId(court.getCourtId(), centerFilterDTO.getDate());
        
        for (TimeInterval timeInterval : timeIntervals) {
            court.getTimeIntervals().removeIf(t -> t.getStartHour() == timeInterval.getStartHour());
        }

        for (TimeInterval timeInterval : court.getTimeIntervals()) {
            if (!timeIntervalDTOs.stream().anyMatch(t -> HourConverter.stringToHour(t.getStartHour()) == timeInterval.getStartHour()))
                timeIntervalDTOs.add(timeIntervalMapper.entityToDTO(timeInterval));
        }

        return timeIntervalDTOs;
    }
    
}
