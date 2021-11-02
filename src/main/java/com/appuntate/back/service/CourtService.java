package com.appuntate.back.service;

import java.util.List;

import javax.transaction.Transactional;

import com.appuntate.back.mapper.CourtMapper;
import com.appuntate.back.model.Court;
import com.appuntate.back.model.TimeInterval;
import com.appuntate.back.model.dto.CourtDTO;
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
    private CourtMapper courtMapper;

    public Court getCourtByCodCourt(long codCourt) {
        return courtRepository.getById(codCourt);
    }

    @Transactional
    public void saveCourt(CourtDTO courtDTO) {
        Court court = courtMapper.DtoToEntity(courtDTO);
        
        if(!court.getTimeIntervals().isEmpty()) {
            timeIntervalService.setCourtToTimeInterval(court);
            courtRepository.save(court);
        }
    }

}
