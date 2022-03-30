package com.appuntate.back.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.appuntate.back.exceptionHandler.exceptions.badRequest.TimeIntervalCreateException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.CenterWithAvailableCourtsNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.CourtByFilterNotFoundException;
import com.appuntate.back.mapper.court.CourtMapper;
import com.appuntate.back.mapper.court.CourtResponseMapper;
import com.appuntate.back.mapper.court.CourtSaveMapper;
import com.appuntate.back.model.Court;
import com.appuntate.back.model.TimeInterval;
import com.appuntate.back.model.criteria.CourtCriteria;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.court.CourtDTO;
import com.appuntate.back.model.dto.court.CourtFilterDTO;
import com.appuntate.back.model.dto.court.CourtRequestDTO;
import com.appuntate.back.model.dto.court.CourtResponseDTO;
import com.appuntate.back.model.dto.court.CourtSaveDTO;
import com.appuntate.back.repository.CourtRepository;
import com.appuntate.back.service.criteria.CourtCriteriaService;
import com.appuntate.back.service.specification.CourtSpecificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jhipster.service.QueryService;

@Service
public class CourtService extends QueryService<Court> {

    @Autowired
    private CourtRepository courtRepository;

    @Autowired
    private TimeIntervalService timeIntervalService;

    @Autowired
    private CourtSaveMapper courtSaveMapper;

    @Autowired
    private CourtMapper courtMapper;

    @Autowired
    private CenterService centerService;

    @Autowired
    private CourtResponseMapper courtResponseMapper;

    @Autowired
    private CourtCriteriaService courtCriteriaService;

    @Autowired
    private CourtSpecificationService courtSpecificationService;


    public Court getCourtById(long courtId) {
        return courtRepository.getById(courtId);
    }

    @Transactional
    public ConfirmationOutputMap saveCourt(CourtSaveDTO courtDTO) throws TimeIntervalCreateException {
        Court court = courtSaveMapper.DtoToEntity(courtDTO);
        
        if(!court.getTimeIntervals().isEmpty()) {
            timeIntervalService.setCourtToTimeInterval(court);
            courtRepository.save(court);
            centerService.updateCenterMinimumPrice(courtDTO.getCenterId(), courtDTO.getPrice());
            return new ConfirmationOutputMap(true, "Pista creada correctamente");
        } else throw new TimeIntervalCreateException();
    }

    public List<CourtResponseDTO> getCourtByDate(CourtRequestDTO courtInputDTO) {
        return courtResponseMapper.entitiesToDTOs(timeIntervalService.getAvailableTimeIntervalByCenterIdAndSport(courtInputDTO.getCenterId(), courtInputDTO.getSport(),
                                                                                                         courtInputDTO.getHour(), courtInputDTO.getDate()));
    }
 
    public List<CourtDTO> getCourtByFilters(CourtFilterDTO courtFilterDTO) throws CourtByFilterNotFoundException {
        CourtCriteria courtCriteria = courtCriteriaService.createCriteria(courtFilterDTO);
        List<Court> courts = courtRepository.findAll(courtSpecificationService.createSpecification(courtCriteria));
        if(!courts.isEmpty()) return setAbailableHours(courts, courtFilterDTO);
        throw new CourtByFilterNotFoundException();
    }

    private List<CourtDTO> setAbailableHours(List<Court> courts, CourtFilterDTO courtFilterDTO) throws CourtByFilterNotFoundException {
        List<CourtDTO> courtDTOs = courtMapper.entitiesToDTOsDateAndHour(courts, courtFilterDTO.getDate(), courtFilterDTO.getHour());
        if(!courtDTOs.isEmpty()) return courtDTOs;
        throw new CourtByFilterNotFoundException();
    }

}
