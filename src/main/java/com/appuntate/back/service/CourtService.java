package com.appuntate.back.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import com.appuntate.back.model.Center_;
import com.appuntate.back.model.Court;
import com.appuntate.back.model.Court_;
import com.appuntate.back.model.Sport_;
import com.appuntate.back.model.TimeInterval_;
import com.appuntate.back.model.TownHall_;
import com.appuntate.back.model.Town_;
import com.appuntate.back.model.criteria.CourtCriteria;
import com.appuntate.back.repository.CourtRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import io.github.jhipster.service.QueryService;

@Service
public class CourtService extends QueryService<Court> {

    @Autowired
    private CourtRepository courtRepository;

    public List<Court> getCourtsByFilters(CourtCriteria courtCriteria) {
        
        Specification<Court> specification = createSpecification(courtCriteria);
        return courtRepository.findAll(specification);
    }

    private Specification<Court> createSpecification(CourtCriteria courtCriteria) {
        
        Specification<Court> specification = Specification.where(null);

        if(courtCriteria.getTown() != null) 
            specification = specification.and(buildSpecification(courtCriteria.getTown(), root -> root
                .join(Court_.sport, JoinType.LEFT)
                    .join(Sport_.center, JoinType.LEFT)
                        .join(Center_.townHall, JoinType.LEFT)
                            .join(TownHall_.town, JoinType.LEFT)
                                .get(Town_.name)));
            
        if(courtCriteria.getSport() != null)
            specification = specification.and(buildSpecification(courtCriteria.getSport(), root -> root
                .join(Court_.sport, JoinType.LEFT)
                    .get(Sport_.name)));

        if(courtCriteria.getHour() != null) 
            specification = specification.and(buildSpecification(courtCriteria.getHour(), root -> root
                .join(Court_.timeIntervals, JoinType.LEFT)
                    .get(TimeInterval_.startHour)));

        return specification;
    }
    
}
