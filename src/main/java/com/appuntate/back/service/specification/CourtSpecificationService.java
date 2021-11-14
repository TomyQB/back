package com.appuntate.back.service.specification;

import javax.persistence.criteria.JoinType;

import com.appuntate.back.model.Center_;
import com.appuntate.back.model.Court;
import com.appuntate.back.model.Court_;
import com.appuntate.back.model.Sport_;
import com.appuntate.back.model.SportsNames_;
import com.appuntate.back.model.TimeInterval_;
import com.appuntate.back.model.TownHall_;
import com.appuntate.back.model.Town_;
import com.appuntate.back.model.criteria.CourtCriteria;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import io.github.jhipster.service.QueryService;

@Service
public class CourtSpecificationService extends QueryService<Court> implements SpecificationService<Court, CourtCriteria> {

    @Override
    public Specification<Court> createSpecification(CourtCriteria criteria) {
        
        Specification<Court> specification = (root, query, cb) -> { query.distinct(true); return null; };

        if(criteria.getTown() != null)
            specification = specification.and(buildSpecification(criteria.getTown(), root -> root
                .join(Court_.sport, JoinType.LEFT)
                    .join(Sport_.center, JoinType.LEFT)
                        .join(Center_.townHall, JoinType.LEFT)
                            .join(TownHall_.town, JoinType.LEFT)
                                .get(Town_.name)));
            
        if(criteria.getSport() != null)
            specification = specification.and(buildSpecification(criteria.getSport(), root -> root
                .join(Court_.sport, JoinType.LEFT)
                    .join(Sport_.sportsNames, JoinType.LEFT)
                        .get(SportsNames_.name)));

        if(criteria.getHour() != null)
            specification = specification.and(buildSpecification(criteria.getHour(), root -> root
                .join(Court_.timeIntervals, JoinType.LEFT)
                    .get(TimeInterval_.startHour)));


        return specification;
    }
    
}
