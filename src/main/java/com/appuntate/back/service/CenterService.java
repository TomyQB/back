package com.appuntate.back.service;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.notFound.CenterWithAvailableCourtsNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.CentersByFilterNotFoundException;
import com.appuntate.back.mapper.center.CenterCompleteResponseMapper;
import com.appuntate.back.mapper.center.CenterResponseMapper;
import com.appuntate.back.mapper.timeInterval.TimeIntervalMapper;
import com.appuntate.back.model.Center;
import com.appuntate.back.model.Court;
import com.appuntate.back.model.TimeInterval;
import com.appuntate.back.model.criteria.CenterCriteria;
import com.appuntate.back.model.dto.center.CenterCompleteResponseDTO;
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
    private CenterCompleteResponseMapper centerCompleteResponseMapper;


    public CenterCompleteResponseDTO getCenterById(long centerId, String date) {
        return centerCompleteResponseMapper.entityToDTONotReserved(centerRepository.getById(centerId), date);
    }

    public Center getCenterByCodCourt(long courtId) {
        return centerRepository.findBySportsCourtsCourtId(courtId);
    }

    public List<CenterResponseDTO> getCentersByFilters(CenterFilterDTO centerFilterDTO) throws CentersByFilterNotFoundException, CenterWithAvailableCourtsNotFoundException {
        CenterCriteria centerCriteria = centerCriteriaService.createCriteria(centerFilterDTO);
        List<Center> centers = centerRepository.findAll(centerSpecificationService.createSpecification(centerCriteria));
        if(!centers.isEmpty()) return setDistanceAndAbailableHours(centers, centerFilterDTO);
        throw new CentersByFilterNotFoundException();

    }

    private List<CenterResponseDTO> setDistanceAndAbailableHours(List<Center> centers, CenterFilterDTO centerFilterDTO) throws CenterWithAvailableCourtsNotFoundException {
        List<CenterResponseDTO> centerResponseDTOs = new ArrayList<>();

        for(Center center : centers) {
            CenterResponseDTO centerDTO = centerResponseMapper.entityToDTO(center);
            centerDTO.setDistance(calculateDistanceWithLongLat(center, centerFilterDTO));
            centerDTO.setAvailableIntervals(timeIntervalService.getInterestedTimeIntervals(center.getCenterId(), centerFilterDTO.getDate(), HourConverter.stringToHour(centerFilterDTO.getHour())));
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

    public void updateCenterMinimumPrice(long centerId, double price) {
        Center center = centerRepository.getById(centerId);
        if(center.getMinimumPrice() == 0) updateMinimumPrice(center, price);
        else if(center.getMinimumPrice() > price) updateMinimumPrice(center, price);
    }

    private void updateMinimumPrice(Center center, double price) {
        center.setMinimumPrice(price);
        centerRepository.save(center);
    }
    
}
