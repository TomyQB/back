package com.appuntate.back.service.specification;


import java.util.Objects;

import javax.persistence.criteria.JoinType;

import com.appuntate.back.model.Center;
import com.appuntate.back.model.Center_;
import com.appuntate.back.model.Sport_;
import com.appuntate.back.model.SportsNames_;
import com.appuntate.back.model.criteria.CenterCriteria;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import io.github.jhipster.service.QueryService;

@Service
public class CenterSpecificationService extends QueryService<Center> implements ISpecificationService<Center, CenterCriteria> {

    @Override
    public Specification<Center> createSpecification(CenterCriteria criteria) {
        
        Specification<Center> specification = (root, query, cb) -> { query.distinct(true); return null; };

            
        if(Objects.nonNull(criteria.getSport()))
            specification = specification.and(buildSpecification(criteria.getSport(), root -> root
                .join(Center_.sports, JoinType.LEFT)
                    .join(Sport_.sportName, JoinType.LEFT)
                        .get(SportsNames_.name)));

        if(Objects.nonNull(criteria.getLatitude()))
            specification = specification.and(buildRangeSpecification(criteria.getLatitude(), Center_.latitude));
            
        if(Objects.nonNull(criteria.getLongitude()))
            specification = specification.and(buildRangeSpecification(criteria.getLongitude(), Center_.longitude));

        if(Objects.nonNull(criteria.getRating()))
            specification = specification.and(buildRangeSpecification(criteria.getRating(), Center_.rating));


        return specification;
    }
    
}
