package com.appuntate.back.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import com.appuntate.back.model.Center;
import com.appuntate.back.model.Center_;
import com.appuntate.back.model.Sport_;
import com.appuntate.back.model.TownHall_;
import com.appuntate.back.model.Town_;
import com.appuntate.back.model.criteria.CenterCriteria;
import com.appuntate.back.model.dto.CenterFilterDTO;
import com.appuntate.back.repository.CenterRepository;
import com.appuntate.back.service.criteria.CenterCriteriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import io.github.jhipster.service.QueryService;

@Service
public class CenterService extends QueryService<Center> {
    
    @Autowired
    private CenterRepository centerRepository;
    
    @Autowired
    private CenterCriteriaService centerCriteriaService;

    public List<Center> getCentersByFilters(CenterFilterDTO centerFilterDTO) {
        
        CenterCriteria centerCriteria = centerCriteriaService.createCriteria(centerFilterDTO);
        Specification<Center> specification = createSpecification(centerCriteria);
        return centerRepository.findAll(specification);
    }

    private Specification<Center> createSpecification(CenterCriteria centerCriteria) {
        
        Specification<Center> specification = (root, query, cb) -> { query.distinct(true); return null; };

        if(centerCriteria.getTown() != null)
            specification = specification.and(buildSpecification(centerCriteria.getTown(), root -> root
                .join(Center_.townHall, JoinType.LEFT)
                    .join(TownHall_.town, JoinType.LEFT)
                        .get(Town_.name)));
            
        if(centerCriteria.getSport() != null)
            specification = specification.and(buildSpecification(centerCriteria.getSport(), root -> root
                .join(Center_.sports, JoinType.LEFT)
                    .get(Sport_.name)));

        // if(centerCriteria.getHour() != null)
        //     specification = specification.and(buildSpecification(centerCriteria.getHour(), root -> root
        //         .join(Court_.timeIntervals, JoinType.LEFT)
        //             .get(TimeInterval_.startHour)));
                    
        // if(courtCriteria.getHour() != null) 
        //     specification = specification.and(buildSpecification(courtCriteria.getHour(), root -> root
        //         .join(Court_.timeIntervals, JoinType.LEFT)
        //             .join(TimeInterval_.codTimeInterval)
        //                 .join(collection)));


        return specification;
    }
    
}
