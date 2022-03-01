package com.appuntate.back.service;

import java.util.List;

import javax.transaction.Transactional;

import com.appuntate.back.exceptionHandler.exceptions.badRequest.TimeIntervalCreateException;
import com.appuntate.back.mapper.court.CourtMapper;
import com.appuntate.back.mapper.court.CourtSaveMapper;
import com.appuntate.back.model.Court;
import com.appuntate.back.model.TimeInterval;
import com.appuntate.back.model.criteria.CourtCriteria;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.court.CourtDTO;
import com.appuntate.back.model.dto.court.CourtFilterDTO;
import com.appuntate.back.model.dto.court.CourtInputDTO;
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
    private CourtCriteriaService courtCriteriaService;

    @Autowired
    private CourtSpecificationService courtSpecificationService;

    public Court getCourtByCodCourt(long courtId) {
        return courtRepository.getById(courtId);
    }

    @Transactional
    public ConfirmationOutputMap saveCourt(CourtSaveDTO courtDTO) throws TimeIntervalCreateException {
        Court court = courtSaveMapper.DtoToEntity(courtDTO);
        
        if(!court.getTimeIntervals().isEmpty()) {
            timeIntervalService.setCourtToTimeInterval(court);
            courtRepository.save(court);
            return new ConfirmationOutputMap(true, "Pista creada correctamente");
        } else throw new TimeIntervalCreateException();
    }

    public List<CourtDTO> getCourtsByFilter(CourtFilterDTO courtFilterDTO) {
        CourtCriteria courtCriteria = courtCriteriaService.createCriteria(courtFilterDTO);
        List<Court> courts = courtRepository.findAll(courtSpecificationService.createSpecification(courtCriteria));

        courts = deleteNotInterestedHours(courts, courtFilterDTO);
        courts = deleteReserveddHoursList(courts, courtFilterDTO);

        return courtMapper.entitiesToDTOs(courts);
    }

    public CourtDTO getCourtByDate(CourtInputDTO courtInputDTO) {
        Court court = courtRepository.getById(courtInputDTO.getCourtId());

        court = deleteReservedHours(courtInputDTO.getDate(), court);

        return courtMapper.entityToDTO(court);
    }
    
    private List<Court> deleteNotInterestedHours(List<Court> courts, CourtFilterDTO courtFilterDTO) {
        
        for (Court court : courts) {
            if(courtFilterDTO.getHour() != null)
                court.getTimeIntervals().removeIf(t -> t.getStartHour() < HourConverter.stringToHour(courtFilterDTO.getHour()));                 
        }

        return courts;
    }

    private List<Court> deleteReserveddHoursList(List<Court> courts, CourtFilterDTO courtFilterDTO) {
        
        for (Court court : courts) {
            deleteReservedHours(courtFilterDTO.getDate(), court);
        }

        return courts;

    }

    private Court deleteReservedHours(String date, Court court) {
        List<TimeInterval> timeIntervals = timeIntervalService.getTimeIntervalsReservedByCourtId(court.getCourtId(), date);
        for (TimeInterval timeInterval : timeIntervals) {
            court.getTimeIntervals().removeIf(t -> t.getStartHour() == timeInterval.getStartHour());
        }

        return court;
    }

}
