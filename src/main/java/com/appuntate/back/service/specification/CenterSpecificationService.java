package com.appuntate.back.service.specification;


import javax.persistence.criteria.JoinType;

import com.appuntate.back.model.Center;
import com.appuntate.back.model.Center_;
import com.appuntate.back.model.Court_;
import com.appuntate.back.model.Sport_;
import com.appuntate.back.model.SportsNames_;
import com.appuntate.back.model.TimeInterval_;
import com.appuntate.back.model.TownHall_;
import com.appuntate.back.model.Town_;
import com.appuntate.back.model.criteria.CenterCriteria;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import io.github.jhipster.service.QueryService;

@Service
public class CenterSpecificationService extends QueryService<Center> implements SpecificationService<Center, CenterCriteria> {

    @Override
    public Specification<Center> createSpecification(CenterCriteria criteria) {
        
        Specification<Center> specification = (root, query, cb) -> { query.distinct(true); return null; };

        if(criteria.getTown() != null)
            specification = specification.and(buildSpecification(criteria.getTown(), root -> root
                .join(Center_.townHall, JoinType.LEFT)
                    .join(TownHall_.town, JoinType.LEFT)
                        .get(Town_.name)));
            
        if(criteria.getSport() != null)
            specification = specification.and(buildSpecification(criteria.getSport(), root -> root
                .join(Center_.sports, JoinType.LEFT)
                    .join(Sport_.sportsNames, JoinType.LEFT)
                        .get(SportsNames_.name)));

        if(criteria.getHour() != null)
            specification = specification.and(buildSpecification(criteria.getHour(), root -> root
                .join(Center_.sports, JoinType.LEFT)
                    .join(Sport_.courts, JoinType.LEFT)
                        .join(Court_.timeIntervals, JoinType.LEFT)
                            .get(TimeInterval_.startHour)));


        return specification;
    }
    
}