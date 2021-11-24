package com.appuntate.back.service;

import java.util.List;

import javax.transaction.Transactional;

import com.appuntate.back.mapper.CourtMapper;
import com.appuntate.back.mapper.CourtSaveMapper;
import com.appuntate.back.model.Court;
import com.appuntate.back.model.TimeInterval;
import com.appuntate.back.model.criteria.CourtCriteria;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.CourtDTO;
import com.appuntate.back.model.dto.CourtSaveDTO;
import com.appuntate.back.model.dto.CourtFilterDTO;
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
    private CourtCriteriaService courtCriteriaService;

    @Autowired
    private CourtSpecificationService courtSpecificationService;

    public Court getCourtByCodCourt(long codCourt) {
        return courtRepository.getById(codCourt);
    }

    @Transactional
    public ConfirmationOutputMap saveCourt(CourtSaveDTO courtDTO) {
        Court court = courtSaveMapper.DtoToEntity(courtDTO);
        ConfirmationOutputMap confirmationOutputMap = new ConfirmationOutputMap(false, "Error al crear la pista");
        
        if(!court.getTimeIntervals().isEmpty()) {
            timeIntervalService.setCourtToTimeInterval(court);
            courtRepository.save(court);
            confirmationOutputMap.setOk(true);
            confirmationOutputMap.setMessage("Pista creada correctamente");
        } else confirmationOutputMap.setMessage("Error en el horario de la pista");

        return confirmationOutputMap;
        
    }

    public List<CourtDTO> getCourtsByFilter(CourtFilterDTO courtFilterDTO) {
        CourtCriteria courtCriteria = courtCriteriaService.createCriteria(courtFilterDTO);
        List<Court> courts = courtRepository.findAll(courtSpecificationService.createSpecification(courtCriteria));

        courts = deleteNotInterestedHours(courts, courtFilterDTO);
        courts = deleteReserveddHours(courts, courtFilterDTO);

        return courtMapper.entityToDTO(courts);
    }
    
    private List<Court> deleteNotInterestedHours(List<Court> courts, CourtFilterDTO courtFilterDTO) {
        
        for (Court court : courts) {
            if(courtFilterDTO.getHour() != null)
                court.getTimeIntervals().removeIf(t -> t.getStartHour() < HourConverter.stringToHour(courtFilterDTO.getHour()));                 
        }

        return courts;
    }

    private List<Court> deleteReserveddHours(List<Court> courts, CourtFilterDTO courtFilterDTO) {
        
        for (Court court : courts) {
            List<TimeInterval> timeIntervals = timeIntervalService.getTimeIntervalsReservedByCourtId(court.getCodCourt(), courtFilterDTO.getDate());
            for (TimeInterval timeInterval : timeIntervals) {
                court.getTimeIntervals().removeIf(t -> t.getStartHour() == timeInterval.getStartHour());
            }
        }

        return courts;

    }

}
