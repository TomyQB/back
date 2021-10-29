package com.appuntate.back.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import com.appuntate.back.mapper.CourtMapper;
import com.appuntate.back.model.Center_;
import com.appuntate.back.model.Court;
import com.appuntate.back.model.Court_;
import com.appuntate.back.model.Sport_;
import com.appuntate.back.model.TimeInterval_;
import com.appuntate.back.model.TownHall_;
import com.appuntate.back.model.Town_;
import com.appuntate.back.model.dto.CourtDTO;
import com.appuntate.back.repository.CourtRepository;

import org.hibernate.criterion.Distinct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import io.github.jhipster.service.QueryService;

@Service
public class CourtService extends QueryService<Court> {

    @Autowired
    private CourtRepository courtRepository;

    @Autowired
    private CourtMapper courtMapper;

    public void addCourt(CourtDTO courtDTO) {
        courtRepository.save(courtMapper.DtoToEntity(courtDTO));
    }

}
