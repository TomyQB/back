package com.appuntate.back.service.specification;

import javax.persistence.criteria.JoinType;

import com.appuntate.back.model.Center_;
import com.appuntate.back.model.Event;
import com.appuntate.back.model.Event_;
import com.appuntate.back.model.Sport_;
import com.appuntate.back.model.SportsNames_;
import com.appuntate.back.model.criteria.EventCriteria;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import io.github.jhipster.service.QueryService;

@Service
public class EventSpecificationService  extends QueryService<Event> implements ISpecificationService<Event, EventCriteria> {

    @Override
    public Specification<Event> createSpecification(EventCriteria criteria) {
        Specification<Event> specification = (root, query, cb) -> { query.distinct(true); return null; };

        if(criteria.getSport() != null)
            specification = specification.and(buildSpecification(criteria.getSport(), root -> root
                .join(Event_.sport, JoinType.LEFT)
                    .join(Sport_.sportName, JoinType.LEFT)
                        .get(SportsNames_.name)));
                    
        if(criteria.getLatitude() != null)
            specification = specification.and(buildSpecification(criteria.getLatitude(), root -> root
                .join(Event_.sport, JoinType.LEFT)
                    .join(Sport_.center, JoinType.LEFT)
                        .get(Center_.latitude)));
        
        if(criteria.getLongitude() != null)
            specification = specification.and(buildSpecification(criteria.getLongitude(), root -> root
                .join(Event_.sport, JoinType.LEFT)
                    .join(Sport_.center, JoinType.LEFT)
                        .get(Center_.longitude)));

                        
        return specification;
    }
    
}
