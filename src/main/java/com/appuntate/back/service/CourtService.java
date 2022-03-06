package com.appuntate.back.service;

import java.util.List;

import javax.transaction.Transactional;

import com.appuntate.back.exceptionHandler.exceptions.badRequest.TimeIntervalCreateException;
import com.appuntate.back.mapper.court.CourtMapper;
import com.appuntate.back.mapper.court.CourtSaveMapper;
import com.appuntate.back.model.Court;
import com.appuntate.back.model.TimeInterval;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.court.CourtDTO;
import com.appuntate.back.model.dto.court.CourtInputDTO;
import com.appuntate.back.model.dto.court.CourtSaveDTO;
import com.appuntate.back.repository.CourtRepository;

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
    private CenterService centerService;

    public Court getCourtByCodCourt(long courtId) {
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


}
