package com.appuntate.back.service;

import java.util.List;

import com.appuntate.back.model.Court;
import com.appuntate.back.model.Court_;
import com.appuntate.back.model.Sport_;
import com.appuntate.back.model.criteria.CourtCriteria;
import com.appuntate.back.repository.CourtRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

// import io.github.jhipster.service.QueryService;

@Service
public class CourtService /*extends QueryService<Court>*/ {

    @Autowired
    private CourtRepository courtRepository;

    public List<Court> getCourtsByFilters(CourtCriteria courtCriteria) {

        Specification<Court> specification = Specification.where(null);

        // if(courtCriteria.getTown() != null) {
        //     specification = specification.and(buildReferringEntitySpecification(courtCriteria.getTown(), Court_.sport, Sport_.name));
        // }

        return null;
    }
    
}
