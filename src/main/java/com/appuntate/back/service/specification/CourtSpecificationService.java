package com.appuntate.back.service.specification;

import java.util.Objects;

import javax.persistence.criteria.JoinType;

import com.appuntate.back.model.Center_;
import com.appuntate.back.model.Court;
import com.appuntate.back.model.Court_;
import com.appuntate.back.model.Sport_;
import com.appuntate.back.model.SportsNames_;
import com.appuntate.back.model.criteria.CourtCriteria;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import io.github.jhipster.service.QueryService;

@Service
public class CourtSpecificationService extends QueryService<Court> implements ISpecificationService<Court, CourtCriteria> {

    @Override
    public Specification<Court> createSpecification(CourtCriteria criteria) {

        Specification<Court> specification = (root, query, cb) -> { query.distinct(true); return null; };

        if(Objects.nonNull(criteria.getSport()))
            specification = specification.and(buildSpecification(criteria.getSport(), root -> root
                .join(Court_.sport, JoinType.LEFT)
                    .join(Sport_.sportName, JoinType.LEFT)
                        .get(SportsNames_.name)));

        if(Objects.nonNull(criteria.getCenterId()))
            specification = specification.and(buildSpecification(criteria.getCenterId(), root -> root
                .join(Court_.sport, JoinType.LEFT)
                    .join(Sport_.center, JoinType.LEFT)
                        .get(Center_.centerId)));

                        
        return specification;
    }
    
}
